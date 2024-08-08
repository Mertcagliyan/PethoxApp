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
import com.mertcagliyan.pethox2.databinding.ActivityUploadForMatchingBinding;
import com.squareup.picasso.Picasso;
import java.util.HashMap;

public class UploadForMatchingActivity extends AppCompatActivity {
    String Female = "Dişi";
    String Male = "Erkek";
    ActivityResultLauncher<Intent> activityResultLauncher;
    private FirebaseAuth auth;
    private ActivityUploadForMatchingBinding binding;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseStorage firebaseStorage;
    Uri imageData;
    ActivityResultLauncher<String> permissionLauncher;
    SharedPreferences sharedPreferences;
    private StorageReference storageReference;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityUploadForMatchingBinding inflate = ActivityUploadForMatchingBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView((View) inflate.getRoot());
        registerLauncher();
        this.firebaseStorage = FirebaseStorage.getInstance();
        this.firebaseFirestore = FirebaseFirestore.getInstance();
        this.storageReference = FirebaseStorage.getInstance().getReference();
        this.binding.maleText2.setVisibility(4);
        this.binding.femaleText2.setVisibility(4);
        SharedPreferences sharedPreferences2 = getSharedPreferences("com.mertcagliyan.pethox2.view", 0);
        this.sharedPreferences = sharedPreferences2;
        sharedPreferences2.edit().remove("female").apply();
        this.sharedPreferences.edit().remove("male").apply();
        this.auth = FirebaseAuth.getInstance();
    }

    public void male(View view) {
        this.binding.maleText.setVisibility(4);
        this.binding.maleText2.setVisibility(0);
        this.sharedPreferences.edit().remove("female").apply();
        this.sharedPreferences.edit().putString("male", this.Male).apply();
        this.binding.femaleText2.setVisibility(4);
        this.binding.femaleText.setVisibility(0);
    }

    public void male2(View view) {
        this.binding.maleText.setVisibility(0);
        this.binding.maleText2.setVisibility(4);
        this.sharedPreferences.edit().remove("male").apply();
    }

    public void female(View view) {
        this.binding.femaleText.setVisibility(4);
        this.binding.femaleText2.setVisibility(0);
        this.sharedPreferences.edit().remove("male").apply();
        this.sharedPreferences.edit().putString("female", this.Female).apply();
        this.binding.maleText2.setVisibility(4);
        this.binding.maleText.setVisibility(0);
    }

    public void female2(View view) {
        this.binding.femaleText.setVisibility(0);
        this.binding.femaleText2.setVisibility(4);
        this.sharedPreferences.edit().remove("female").apply();
    }

    public void UploadButton(View view) {
        String string = this.sharedPreferences.getString("resultUriMatching", (String) null);
        String obj = this.binding.nameText.getText().toString();
        String obj2 = this.binding.ageText.getText().toString();
        String obj3 = this.binding.specieText.getText().toString();
        String string2 = this.sharedPreferences.getString("username", (String) null);
        String string3 = this.sharedPreferences.getString("profilephoto", (String) null);
        String string4 = this.sharedPreferences.getString("male", (String) null);
        String string5 = this.sharedPreferences.getString("female", (String) null);
        HashMap hashMap = new HashMap();
        hashMap.put("downloadurl", string);
        hashMap.put("nametext", obj);
        hashMap.put("specietext", obj3);
        hashMap.put("agetext", obj2);
        hashMap.put("date", FieldValue.serverTimestamp());
        hashMap.put("profilephoto", string3);
        hashMap.put("username", string2);
        if (string4 != null) {
            hashMap.put("gender", string4);
        } else {
            hashMap.put("gender", string5);
        }
        this.firebaseFirestore.collection("Matching Pets").add(hashMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            public void onSuccess(DocumentReference documentReference) {
                UploadForMatchingActivity.this.sharedPreferences.edit().remove("resultUriMatching").apply();
                UploadForMatchingActivity.this.startActivity(new Intent(UploadForMatchingActivity.this, SocialMediaActivity.class));
                UploadForMatchingActivity.this.finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception exc) {
                Toast.makeText(UploadForMatchingActivity.this, "Hayvan yüklenemedi!", 1).show();
            }
        });
    }

    public void selectImage(View view) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            this.activityResultLauncher.launch(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI));
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_EXTERNAL_STORAGE")) {
            Snackbar.make(view, (CharSequence) "Permission need for gallery", -2).setAction((CharSequence) "Give Permission", (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    UploadForMatchingActivity.this.permissionLauncher.launch("android.permission.READ_EXTERNAL_STORAGE");
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
                    UploadForMatchingActivity.this.imageData = data.getData();
                    Intent intent = new Intent(UploadForMatchingActivity.this, CropperActivityForMatching.class);
                    intent.putExtra("Data", UploadForMatchingActivity.this.imageData.toString());
                    UploadForMatchingActivity.this.startActivityForResult(intent, 100);
                }
            }
        });
        this.permissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            public void onActivityResult(Boolean bool) {
                if (bool.booleanValue()) {
                    UploadForMatchingActivity.this.activityResultLauncher.launch(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI));
                    return;
                }
                Toast.makeText(UploadForMatchingActivity.this, "Permission needed!", 1).show();
            }
        });
    }

    public void backIcon2(View view) {
        startActivity(new Intent(this, SocialMediaActivity.class));
        finish();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 1 && i == 100) {
            String stringExtra = intent.getStringExtra("Result");
            if (stringExtra != null) {
                Picasso.get().load(Uri.parse(stringExtra)).resize(LogSeverity.NOTICE_VALUE, LogSeverity.NOTICE_VALUE).centerCrop().into(this.binding.selectPet);
                this.sharedPreferences.edit().putString("resultUriMatching", stringExtra).apply();
                return;
            }
            Toast.makeText(this, "Hata!", 0).show();
        }
    }
}
