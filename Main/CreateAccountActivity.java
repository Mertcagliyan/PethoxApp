package com.mertcagliyan.pethox2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.logging.type.LogSeverity;
import com.mertcagliyan.pethox2.databinding.ActivityCreateAccountBinding;
import com.squareup.picasso.Picasso;
import java.util.HashMap;
import java.util.UUID;

public class CreateAccountActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> activityResultLauncher;
    /* access modifiers changed from: private */
    public FirebaseAuth auth;
    private ActivityCreateAccountBinding binding;
    /* access modifiers changed from: private */
    public FirebaseFirestore firebaseFirestore;
    /* access modifiers changed from: private */
    public FirebaseStorage firebaseStorage;
    ActivityResultLauncher<String> permissionLauncher;
    HashMap<String, Object> personData = new HashMap<>();
    Uri profileImage;
    SharedPreferences sharedPreferences;
    private StorageReference storageReference;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityCreateAccountBinding inflate = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView((View) inflate.getRoot());
        registerLauncher();
        this.firebaseStorage = FirebaseStorage.getInstance();
        this.auth = FirebaseAuth.getInstance();
        this.firebaseFirestore = FirebaseFirestore.getInstance();
        this.storageReference = FirebaseStorage.getInstance().getReference();
        this.sharedPreferences = getSharedPreferences("om.mertcagliyan.pethox2.view", 0);
    }

    public void createAnAccount(View view) {
        final String obj = this.binding.emailText2.getText().toString();
        String obj2 = this.binding.passwordText2.getText().toString();
        final String obj3 = this.binding.usernameText.getText().toString();
        final String obj4 = this.binding.premiumKod.getText().toString();
        if (obj.equals("")) {
            Toast.makeText(this, "E-posta giriniz!", 1).show();
        } else if (obj2.equals("")) {
            Toast.makeText(this, "Şifre giriniz!", 1).show();
        } else if (this.profileImage == null) {
            Toast.makeText(this, "Profil fotoğrafı seçiniz!", 1).show();
        } else {
            this.auth.createUserWithEmailAndPassword(obj, obj2).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                public void onSuccess(AuthResult authResult) {
                    CreateAccountActivity.this.personData.put("id", CreateAccountActivity.this.auth.getUid());
                    CreateAccountActivity.this.personData.put("email", obj);
                    CreateAccountActivity.this.personData.put("usernameforsearch", obj3.toLowerCase());
                    CreateAccountActivity.this.personData.put("username", obj3);
                    CreateAccountActivity.this.personData.put("durum", "durum");
                    if (obj4.equals("PT3hKGhL4B")) {
                        CreateAccountActivity.this.personData.put("premium", "aktif");
                    } else if (obj4.equals("PT12KX6UT7")) {
                        CreateAccountActivity.this.personData.put("premium", "aktif");
                    } else if (obj4.equals("PT82fYPSM9")) {
                        CreateAccountActivity.this.personData.put("premium", "aktif");
                    } else if (obj4.equals("PTKaFgJ6X9")) {
                        CreateAccountActivity.this.personData.put("premium", "aktif");
                    } else if (obj4.equals("PT75HLF7jR")) {
                        CreateAccountActivity.this.personData.put("premium", "aktif");
                    } else if (obj4.equals("PT3dn8KRXJ")) {
                        CreateAccountActivity.this.personData.put("premium", "aktif");
                    } else if (obj4.equals("PT8BP96BD6")) {
                        CreateAccountActivity.this.personData.put("premium", "aktif");
                    } else if (obj4.equals("PT27hXGSxM")) {
                        CreateAccountActivity.this.personData.put("premium", "aktif");
                    } else if (obj4.equals("PTKX8JapdL")) {
                        CreateAccountActivity.this.personData.put("premium", "aktif");
                    } else if (obj4.equals("PT9wMgSxbJ")) {
                        CreateAccountActivity.this.personData.put("premium", "aktif");
                    } else {
                        CreateAccountActivity.this.personData.put("premium", "inaktif");
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                public void onFailure(Exception exc) {
                    Toast.makeText(CreateAccountActivity.this, exc.getLocalizedMessage(), 0).show();
                }
            });
        }
        Uri parse = Uri.parse(this.sharedPreferences.getString("resultProfile", (String) null));
        if (parse != null) {
            final String str = "ProfilePhotos/" + UUID.randomUUID() + ".jpg";
            this.storageReference.child(str).putFile(parse).addOnSuccessListener((OnSuccessListener) new OnSuccessListener<UploadTask.TaskSnapshot>() {
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    CreateAccountActivity.this.firebaseStorage.getReference(str).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        public void onSuccess(Uri uri) {
                            CreateAccountActivity.this.personData.put("profilephoto", uri.toString());
                            CreateAccountActivity.this.firebaseFirestore.collection("People").document(CreateAccountActivity.this.auth.getUid()).set(CreateAccountActivity.this.personData).addOnSuccessListener(new OnSuccessListener<Void>() {
                                public void onSuccess(Void voidR) {
                                    CreateAccountActivity.this.sharedPreferences.edit().remove("resultProfile").apply();
                                    Intent intent = new Intent(CreateAccountActivity.this, SocialMediaActivity.class);
                                    intent.addFlags(67108864);
                                    CreateAccountActivity.this.startActivity(intent);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                public void onFailure(Exception exc) {
                                    Toast.makeText(CreateAccountActivity.this, "Kayıt başarısız!", 1).show();
                                }
                            });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        public void onFailure(Exception exc) {
                            Toast.makeText(CreateAccountActivity.this, exc.getLocalizedMessage(), 1).show();
                        }
                    });
                }
            }).addOnFailureListener((OnFailureListener) new OnFailureListener() {
                public void onFailure(Exception exc) {
                    Toast.makeText(CreateAccountActivity.this, exc.getLocalizedMessage(), 1).show();
                }
            });
        }
    }

    public void selectProfilePhoto(View view) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            this.activityResultLauncher.launch(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI));
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.READ_EXTERNAL_STORAGE")) {
            Snackbar.make(view, (CharSequence) "Galeriye gitmek için izin gerekiyor", -2).setAction((CharSequence) "İzin ver", (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    CreateAccountActivity.this.permissionLauncher.launch("android.permission.READ_EXTERNAL_STORAGE");
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
                    CreateAccountActivity.this.profileImage = data.getData();
                    Intent intent = new Intent(CreateAccountActivity.this, CropperActivityForProfile.class);
                    intent.putExtra("Data", CreateAccountActivity.this.profileImage.toString());
                    CreateAccountActivity.this.startActivityForResult(intent, 100);
                }
            }
        });
        this.permissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
            public void onActivityResult(Boolean bool) {
                if (bool.booleanValue()) {
                    CreateAccountActivity.this.activityResultLauncher.launch(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI));
                    return;
                }
                Toast.makeText(CreateAccountActivity.this, "İzin Gerekiyor!", 1).show();
            }
        });
    }

    public void geritusu3(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(67108864);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 1 && i == 100) {
            String stringExtra = intent.getStringExtra("Result");
            if (stringExtra != null) {
                Uri parse = Uri.parse(stringExtra);
                this.sharedPreferences.edit().putString("resultProfile", stringExtra).apply();
                Picasso.get().load(parse).resize(LogSeverity.NOTICE_VALUE, LogSeverity.NOTICE_VALUE).centerCrop().into((ImageView) this.binding.profile);
                return;
            }
            Toast.makeText(this, "Hata!", 0).show();
        }
    }
}
