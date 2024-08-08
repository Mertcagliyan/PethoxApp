package com.mertcagliyan.pethox2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mertcagliyan.pethox2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public FirebaseAuth auth;
    private ActivityMainBinding binding;
    private FirebaseFirestore firebaseFirestore;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView((View) inflate.getRoot());
        this.firebaseFirestore = FirebaseFirestore.getInstance();
        FirebaseAuth instance = FirebaseAuth.getInstance();
        this.auth = instance;
        if (instance.getCurrentUser() != null) {
            startActivity(new Intent(this, SocialMediaActivity.class));
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (this.auth.getCurrentUser() != null && this.auth.getCurrentUser().isEmailVerified()) {
            Toast.makeText(this, "E-posta doğrulandı", 0).show();
            startActivity(new Intent(this, SocialMediaActivity.class));
            finish();
        }
        super.onResume();
    }

    public void signInClicked(View view) {
        String obj = this.binding.emailText.getText().toString();
        String obj2 = this.binding.passwordText.getText().toString();
        if (this.auth.getCurrentUser() != null) {
            if (this.auth.getCurrentUser().isEmailVerified()) {
                Toast.makeText(this, "Giriş başarılı", 0).show();
                startActivity(new Intent(this, SocialMediaActivity.class));
                finish();
                return;
            }
            Toast.makeText(this, "E-posta doğrulanamadı!", 1).show();
        } else if (obj.equals("") || obj2.equals("")) {
            Toast.makeText(this, "E-posta ve şifre giriniz!", 0).show();
        } else {
            this.auth.signInWithEmailAndPassword(obj, obj2).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                public void onSuccess(AuthResult authResult) {
                    MainActivity.this.auth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "E-posta doğrulama linki gönderildi", 1).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        public void onFailure(Exception exc) {
                            Toast.makeText(MainActivity.this, "E-posta doğrulama linki gönderilemedi!", 1).show();
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    Toast.makeText(MainActivity.this, "Giriş başarısız!", 1).show();
                }
            });
        }
    }

    public void signUpClicked(View view) {
        startActivity(new Intent(this, Gizlilik_sozlesmesi.class));
        finish();
    }

    public void forgotPassword(View view) {
        Intent intent = new Intent(this, resetPassword.class);
        intent.addFlags(67108864);
        startActivity(intent);
    }
}
