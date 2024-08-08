package com.mertcagliyan.pethox2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Gizlilik_sozlesmesi extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_gizlilik_sozlesmesi);
    }

    public void devam(View view) {
        if (((CheckBox) findViewById(R.id.okudum)).isChecked()) {
            startActivity(new Intent(this, CreateAccountActivity.class));
            finish();
            return;
        }
        Toast.makeText(this, "Politikayı kabul etmelisiniz!", 0).show();
    }
}
