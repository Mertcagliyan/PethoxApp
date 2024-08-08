package com.mertcagliyan.pethox2.Model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.mertcagliyan.pethox2.R;
import com.mertcagliyan.pethox2.SocialMediaActivity;

public class EditProfile extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_edit_profile);
    }

    public void backIcon(View view) {
        startActivity(new Intent(this, SocialMediaActivity.class));
    }
}
