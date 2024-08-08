package com.mertcagliyan.pethox2.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mertcagliyan.pethox2.Model.EditProfile;
import com.mertcagliyan.pethox2.PremiumHesap;
import com.mertcagliyan.pethox2.R;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    private FirebaseAuth auth;
    private DocumentReference documentReference;
    private FirebaseFirestore firebaseFirestore;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);
        this.auth = FirebaseAuth.getInstance();
        ((ImageView) inflate.findViewById(R.id.f1dzenle)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ProfileFragment.this.startActivity(new Intent(ProfileFragment.this.getActivity(), EditProfile.class));
            }
        });
        ((ImageView) inflate.findViewById(R.id.premiumagecis)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ProfileFragment.this.startActivity(new Intent(ProfileFragment.this.getActivity(), PremiumHesap.class));
            }
        });
        final TextView textView = (TextView) inflate.findViewById(R.id.profileUsername);
        final TextView textView2 = (TextView) inflate.findViewById(R.id.profileEmail);
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.premiumagecis);
        final ImageView imageView2 = (ImageView) inflate.findViewById(R.id.premium);
        final CircleImageView circleImageView = (CircleImageView) inflate.findViewById(R.id.Photoinprofile);
        FirebaseFirestore instance = FirebaseFirestore.getInstance();
        this.firebaseFirestore = instance;
        DocumentReference document = instance.collection("People").document(this.auth.getUid());
        this.documentReference = document;
        document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String obj = documentSnapshot.getData().get("username").toString();
                    String obj2 = documentSnapshot.getData().get("profilephoto").toString();
                    String obj3 = documentSnapshot.getData().get("premium").toString();
                    String obj4 = documentSnapshot.getData().get("email").toString();
                    textView.setText(obj);
                    textView2.setText(obj4);
                    Picasso.get().load(obj2).into((ImageView) circleImageView);
                    if (obj3.equals("aktif")) {
                        imageView2.setVisibility(0);
                        imageView.setVisibility(4);
                        return;
                    }
                    imageView.setVisibility(0);
                    imageView2.setVisibility(4);
                }
            }
        });
        return inflate;
    }
}
