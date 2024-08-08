package com.mertcagliyan.pethox2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.mertcagliyan.pethox2.databinding.ActivityResetPasswordBinding;

public class resetPassword extends AppCompatActivity {
    FirebaseAuth auth;
    ActivityResetPasswordBinding binding;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityResetPasswordBinding inflate = ActivityResetPasswordBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView((View) inflate.getRoot());
        this.auth = FirebaseAuth.getInstance();
    }

    public void geritusu3(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(67108864);
        startActivity(intent);
    }

    public void editPassword(View view) {
        if (this.binding.editTextEmail.equals("")) {
            Toast.makeText(this, "E-posta giriniz", 1).show();
        } else {
            this.auth.sendPasswordResetEmail(this.binding.editTextEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                public void onComplete(Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(resetPassword.this, "Şifre yenileme linki gönderildi", 1).show();
                        resetPassword.this.startActivity(new Intent(resetPassword.this, MainActivity.class));
                        resetPassword.this.finish();
                        return;
                    }
                    Toast.makeText(resetPassword.this, "Şifre yenileme linki gönderilemedi!", 1).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    Toast.makeText(resetPassword.this, "Şifre yenileme linki gönderilemedi!", 1).show();
                }
            });
        }
    }
}
