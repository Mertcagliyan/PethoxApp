package com.mertcagliyan.pethox2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.mertcagliyan.pethox2.databinding.ActivityCropperForMatchingBinding;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.util.UUID;

public class CropperActivityForMatching extends AppCompatActivity {
    ActivityCropperForMatchingBinding binding;
    Uri fileUri;
    String result;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityCropperForMatchingBinding inflate = ActivityCropperForMatchingBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView((View) inflate.getRoot());
        readIntent();
        UCrop.Options options = new UCrop.Options();
        options.setToolbarTitle("Fotoğrafı düzenle");
        UCrop.of(this.fileUri, Uri.fromFile(new File(getCacheDir(), UUID.randomUUID().toString() + ".jpg"))).withOptions(options).useSourceImageAspectRatio().withAspectRatio(135.0f, 135.0f).start(this);
    }

    public void readIntent() {
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            String stringExtra = intent.getStringExtra("Data");
            this.result = stringExtra;
            this.fileUri = Uri.parse(stringExtra);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 69) {
            Uri output = UCrop.getOutput(intent);
            Intent intent2 = new Intent();
            intent2.putExtra("Result", output + "");
            setResult(1, intent2);
            finish();
        } else if (i2 == 96) {
            UCrop.getError(intent);
            Toast.makeText(this, "Hata!", 0).show();
            Intent intent3 = new Intent(this, UploadForMatchingActivity.class);
            intent3.addFlags(67108864);
            startActivity(intent3);
        } else {
            Intent intent4 = new Intent(this, UploadForMatchingActivity.class);
            intent4.addFlags(67108864);
            startActivity(intent4);
        }
    }
}
