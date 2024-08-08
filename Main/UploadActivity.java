package com.mertcagliyan.pethox2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.logging.type.LogSeverity;
import com.mertcagliyan.pethox2.databinding.ActivityUploadBinding;
import com.squareup.picasso.Picasso;
import java.util.HashMap;

public class UploadActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> activityResultLauncher;
    private FirebaseAuth auth;
    private ActivityUploadBinding binding;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseStorage firebaseStorage;
    Uri imageData;
    ActivityResultLauncher<String> permissionLauncher;
    SharedPreferences sharedPreferences;
    private StorageReference storageReference;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityUploadBinding inflate = ActivityUploadBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView((View) inflate.getRoot());
        registerLauncher();
        this.firebaseStorage = FirebaseStorage.getInstance();
        this.auth = FirebaseAuth.getInstance();
        this.firebaseFirestore = FirebaseFirestore.getInstance();
        this.storageReference = FirebaseStorage.getInstance().getReference();
        this.sharedPreferences = getSharedPreferences("com.mertcagliyan.pethox2.view", 0);
    }

    public void uploadButtonClicked(View view) {
        String string = this.sharedPreferences.getString("resultUri", (String) null);
        String obj = this.binding.commentText.getText().toString();
        String string2 = this.sharedPreferences.getString("username", (String) null);
        String string3 = this.sharedPreferences.getString("profilephoto", (String) null);
        HashMap hashMap = new HashMap();
        hashMap.put("downloadurl", string);
        hashMap.put("comment", obj);
        hashMap.put("date", FieldValue.serverTimestamp());
        hashMap.put("profilephoto", string3);
        hashMap.put("username", string2);
        this.firebaseFirestore.collection("Posts").add(hashMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            public void onSuccess(DocumentReference documentReference) {
                UploadActivity.this.sharedPreferences.edit().remove("resultUri").apply();
                UploadActivity.this.startActivity(new Intent(UploadActivity.this, SocialMediaActivity.class));
                UploadActivity.this.finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception exc) {
                Toast.makeText(UploadActivity.this, "Post yüklenemedi!", 1).show();
            }
        });
    }

    public void SelectImage(View view) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            this.activityResultLauncher.launch(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI));
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_EXTERNAL_STORAGE")) {
            Snackbar.make(view, (CharSequence) "Permission need for gallery", -2).setAction((CharSequence) "Give Permission", (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    UploadActivity.this.permissionLauncher.launch("android.permission.READ_EXTERNAL_STORAGE");
                }
            }).show();
        } else {
            this.permissionLauncher.launch("android.permission.READ_EXTERNAL_STORAGE");
        }
    }

    private void registerLauncher() {
        this.activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            public void onActivityResult(ActivityResult activityResult) {
                Intent data;
                if (activityResult.getResultCode() == -1 && (data = activityResult.getData()) != null) {
                    UploadActivity.this.imageData = data.getData();
                    Intent intent = new Intent(UploadActivity.this, CropperActivity.class);
                    intent.putExtra("Data", UploadActivity.this.imageData.toString());
                    UploadActivity.this.startActivityForResult(intent, 100);
                }
            }
        });
        this.permissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            public void onActivityResult(Boolean bool) {
                if (bool.booleanValue()) {
                    UploadActivity.this.activityResultLauncher.launch(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI));
                    return;
                }
                Toast.makeText(UploadActivity.this, "Permission needed!", 1).show();
            }
        });
    }

    public void backIcon(View view) {
        startActivity(new Intent(this, SocialMediaActivity.class));
        finish();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 1 && i == 100) {
            String stringExtra = intent.getStringExtra("Result");
            if (stringExtra != null) {
                Uri parse = Uri.parse(stringExtra);
                this.sharedPreferences.edit().putString("resultUri", stringExtra).apply();
                Picasso.get().load(parse).resize(LogSeverity.NOTICE_VALUE, LogSeverity.NOTICE_VALUE).centerCrop().into(this.binding.imageView2);
                return;
            }
            Toast.makeText(this, "Hata!", 0).show();
        }
    }
}
