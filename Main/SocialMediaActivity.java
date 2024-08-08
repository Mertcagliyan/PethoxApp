package com.mertcagliyan.pethox2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mertcagliyan.pethox2.Fragments.CampaignFragment;
import com.mertcagliyan.pethox2.Fragments.HomeFragment;
import com.mertcagliyan.pethox2.Fragments.MatchingPartnerFragment;
import com.mertcagliyan.pethox2.Fragments.ProfileFragment;
import com.mertcagliyan.pethox2.databinding.ActivitySocialMediaBinding;

public class SocialMediaActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private ActivitySocialMediaBinding binding;
    BottomNavigationView bottomNavigationView;
    CampaignFragment campaignFragment = new CampaignFragment();
    private DocumentReference documentReference;
    private FirebaseFirestore firebaseFirestore;
    HomeFragment homeFragment = new HomeFragment();
    MatchingPartnerFragment matchingPartnerFragment = new MatchingPartnerFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    SharedPreferences sharedPreferences;
    ShelterFragment shelterFragment = new ShelterFragment();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivitySocialMediaBinding inflate = ActivitySocialMediaBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView((View) inflate.getRoot());
        this.auth = FirebaseAuth.getInstance();
        this.firebaseFirestore = FirebaseFirestore.getInstance();
        this.bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, this.homeFragment).commit();
        this.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.campaignBar /*2131230851*/:
                        SocialMediaActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, SocialMediaActivity.this.campaignFragment).commit();
                        return true;
                    case R.id.findPartnerBar /*2131230952*/:
                        SocialMediaActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, SocialMediaActivity.this.matchingPartnerFragment).commit();
                        return true;
                    case R.id.homeBar /*2131230979*/:
                        SocialMediaActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, SocialMediaActivity.this.homeFragment).commit();
                        return true;
                    case R.id.profileBar /*2131231165*/:
                        SocialMediaActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, SocialMediaActivity.this.profileFragment).commit();
                        return true;
                    case R.id.shelterBar /*2131231230*/:
                        SocialMediaActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, SocialMediaActivity.this.shelterFragment).commit();
                        return true;
                    default:
                        return false;
                }
            }
        });
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.sharedPreferences = getSharedPreferences("com.mertcagliyan.pethox2.view", 0);
        DocumentReference document = this.firebaseFirestore.collection("People").document(this.auth.getUid());
        this.documentReference = document;
        document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String obj = documentSnapshot.getData().get("username").toString();
                    String obj2 = documentSnapshot.getData().get("profilephoto").toString();
                    SocialMediaActivity.this.sharedPreferences.edit().putString("username", obj).apply();
                    SocialMediaActivity.this.sharedPreferences.edit().putString("profilephoto", obj2).apply();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception exc) {
                Toast.makeText(SocialMediaActivity.this, exc.getLocalizedMessage(), 0).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.add_post) {
            Intent intent = new Intent(this, UploadActivity.class);
            intent.addFlags(67108864);
            startActivity(intent);
        } else if (menuItem.getItemId() == R.id.signout) {
            this.sharedPreferences.edit().remove("username").apply();
            this.sharedPreferences.edit().remove("profilephoto").apply();
            this.auth.signOut();
            Intent intent2 = new Intent(this, MainActivity.class);
            intent2.addFlags(67108864);
            startActivity(intent2);
        } else if (menuItem.getItemId() == R.id.add_pet) {
            Intent intent3 = new Intent(this, UploadForMatchingActivity.class);
            intent3.addFlags(67108864);
            startActivity(intent3);
        } else if (menuItem.getItemId() == R.id.mail) {
            Intent intent4 = new Intent(this, MessagePeopleList.class);
            intent4.addFlags(67108864);
            startActivity(intent4);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void mailButton(View view) {
        Intent intent = new Intent(this, MessagePeopleList.class);
        intent.addFlags(67108864);
        startActivity(intent);
    }
}
