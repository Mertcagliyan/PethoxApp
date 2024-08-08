package com.mertcagliyan.pethox2;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class messageActivity extends AppCompatActivity {
    private ImageView fotoekle;
    private ImageButton geritusu;
    private ImageView gonder;
    private TextView kullaniciadi;
    private EditText mesajgirdi;
    private CircleImageView profilresim;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_message);
        this.geritusu = (ImageButton) findViewById(R.id.geritusu);
        this.profilresim = (CircleImageView) findViewById(R.id.profilresim);
        this.kullaniciadi = (TextView) findViewById(R.id.kullaniciAdi);
        this.mesajgirdi = (EditText) findViewById(R.id.mesajgirdi);
        this.fotoekle = (ImageView) findViewById(R.id.fotoekle);
        this.gonder = (ImageView) findViewById(R.id.gonder);
    }
}
