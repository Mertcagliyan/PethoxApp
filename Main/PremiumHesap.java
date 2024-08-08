package com.mertcagliyan.pethox2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mertcagliyan.pethox2.databinding.ActivityPremiumHesapBinding;

public class PremiumHesap extends AppCompatActivity {
    FirebaseAuth auth;
    ActivityPremiumHesapBinding binding;
    DocumentReference documentReference;
    FirebaseFirestore firebaseFirestore;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityPremiumHesapBinding inflate = ActivityPremiumHesapBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView((View) inflate.getRoot());
        this.firebaseFirestore = FirebaseFirestore.getInstance();
        this.auth = FirebaseAuth.getInstance();
    }

    public void onaylaButon(View view) {
        String obj = this.binding.kodText.getText().toString();
        if (obj.equals("PT3hOGhl4B")) {
            DocumentReference document = this.firebaseFirestore.collection("People").document(this.auth.getUid());
            this.documentReference = document;
            document.update("premium", (Object) "aktif", new Object[0]).addOnSuccessListener(new OnSuccessListener<Void>() {
                public void onSuccess(Void voidR) {
                    Toast.makeText(PremiumHesap.this, "Kod onaylandı", 1).show();
                    PremiumHesap.this.startActivity(new Intent(PremiumHesap.this, SocialMediaActivity.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    Toast.makeText(PremiumHesap.this, "Hata!", 0).show();
                }
            });
        } else if (obj.equals("PT82fYİSM9")) {
            DocumentReference document2 = this.firebaseFirestore.collection("People").document(this.auth.getUid());
            this.documentReference = document2;
            document2.update("premium", (Object) "aktif", new Object[0]).addOnSuccessListener(new OnSuccessListener<Void>() {
                public void onSuccess(Void voidR) {
                    Toast.makeText(PremiumHesap.this, "Kod onaylandı", 1).show();
                    PremiumHesap.this.startActivity(new Intent(PremiumHesap.this, SocialMediaActivity.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    Toast.makeText(PremiumHesap.this, "Hata!", 0).show();
                }
            });
        } else if (obj.equals("PTKOFOJ6X9")) {
            DocumentReference document3 = this.firebaseFirestore.collection("People").document(this.auth.getUid());
            this.documentReference = document3;
            document3.update("premium", (Object) "aktif", new Object[0]).addOnSuccessListener(new OnSuccessListener<Void>() {
                public void onSuccess(Void voidR) {
                    Toast.makeText(PremiumHesap.this, "Kod onaylandı", 1).show();
                    PremiumHesap.this.startActivity(new Intent(PremiumHesap.this, SocialMediaActivity.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    Toast.makeText(PremiumHesap.this, "Hata!", 0).show();
                }
            });
        } else if (obj.equals("PT75HOF7jR")) {
            DocumentReference document4 = this.firebaseFirestore.collection("People").document(this.auth.getUid());
            this.documentReference = document4;
            document4.update("premium", (Object) "aktif", new Object[0]).addOnSuccessListener(new OnSuccessListener<Void>() {
                public void onSuccess(Void voidR) {
                    Toast.makeText(PremiumHesap.this, "Kod onaylandı", 1).show();
                    PremiumHesap.this.startActivity(new Intent(PremiumHesap.this, SocialMediaActivity.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    Toast.makeText(PremiumHesap.this, "Hata!", 0).show();
                }
            });
        } else if (obj.equals("PTOdn8KRXJ")) {
            DocumentReference document5 = this.firebaseFirestore.collection("People").document(this.auth.getUid());
            this.documentReference = document5;
            document5.update("premium", (Object) "aktif", new Object[0]).addOnSuccessListener(new OnSuccessListener<Void>() {
                public void onSuccess(Void voidR) {
                    Toast.makeText(PremiumHesap.this, "Kod onaylandı", 1).show();
                    PremiumHesap.this.startActivity(new Intent(PremiumHesap.this, SocialMediaActivity.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    Toast.makeText(PremiumHesap.this, "Hata!", 0).show();
                }
            });
        } else if (obj.equals("PT8BPERBD6")) {
            DocumentReference document6 = this.firebaseFirestore.collection("People").document(this.auth.getUid());
            this.documentReference = document6;
            document6.update("premium", (Object) "aktif", new Object[0]).addOnSuccessListener(new OnSuccessListener<Void>() {
                public void onSuccess(Void voidR) {
                    Toast.makeText(PremiumHesap.this, "Kod onaylandı", 1).show();
                    PremiumHesap.this.startActivity(new Intent(PremiumHesap.this, SocialMediaActivity.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    Toast.makeText(PremiumHesap.this, "Hata!", 0).show();
                }
            });
        } else if (obj.equals("PT27hOGSOM")) {
            DocumentReference document7 = this.firebaseFirestore.collection("People").document(this.auth.getUid());
            this.documentReference = document7;
            document7.update("premium", (Object) "aktif", new Object[0]).addOnSuccessListener(new OnSuccessListener<Void>() {
                public void onSuccess(Void voidR) {
                    Toast.makeText(PremiumHesap.this, "Kod onaylandı", 1).show();
                    PremiumHesap.this.startActivity(new Intent(PremiumHesap.this, SocialMediaActivity.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    Toast.makeText(PremiumHesap.this, "Hata!", 0).show();
                }
            });
        } else if (obj.equals("PTKX8JaOdL")) {
            DocumentReference document8 = this.firebaseFirestore.collection("People").document(this.auth.getUid());
            this.documentReference = document8;
            document8.update("premium", (Object) "aktif", new Object[0]).addOnSuccessListener(new OnSuccessListener<Void>() {
                public void onSuccess(Void voidR) {
                    Toast.makeText(PremiumHesap.this, "Kod onaylandı", 1).show();
                    PremiumHesap.this.startActivity(new Intent(PremiumHesap.this, SocialMediaActivity.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    Toast.makeText(PremiumHesap.this, "Hata!", 0).show();
                }
            });
        } else if (obj.equals("PT9wMgSObJ")) {
            DocumentReference document9 = this.firebaseFirestore.collection("People").document(this.auth.getUid());
            this.documentReference = document9;
            document9.update("premium", (Object) "aktif", new Object[0]).addOnSuccessListener(new OnSuccessListener<Void>() {
                public void onSuccess(Void voidR) {
                    Toast.makeText(PremiumHesap.this, "Kod onaylandı", 1).show();
                    PremiumHesap.this.startActivity(new Intent(PremiumHesap.this, SocialMediaActivity.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    Toast.makeText(PremiumHesap.this, "Hata!", 0).show();
                }
            });
        } else if (obj.equals("")) {
            Toast.makeText(this, "Kod giriniz!", 0).show();
        } else {
            Toast.makeText(this, "Kod geçersiz!", 0).show();
        }
    }

    public void backIcon(View view) {
        Intent intent = new Intent(this, SocialMediaActivity.class);
        intent.addFlags(67108864);
        startActivity(intent);
    }
}
