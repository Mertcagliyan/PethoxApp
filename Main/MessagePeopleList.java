package com.mertcagliyan.pethox2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.mertcagliyan.pethox2.Adapter.KullaniciAdapter;
import com.mertcagliyan.pethox2.Model.Kullanici;
import com.mertcagliyan.pethox2.databinding.ActivityMessagePeopleListBinding;
import java.util.ArrayList;
import java.util.Map;

public class MessagePeopleList extends AppCompatActivity {
    /* access modifiers changed from: private */
    public EditText aramaBar;
    private FirebaseAuth auth;
    private DocumentReference documentReference;
    private FirebaseFirestore firebaseFirestore;
    KullaniciAdapter kullaniciAdapter;
    private ActivityMessagePeopleListBinding messagePeopleListBinding;
    private FirebaseUser mevcutkullanici = FirebaseAuth.getInstance().getCurrentUser();
    ArrayList<Kullanici> mkullanicilar;
    SharedPreferences sharedPreferences;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityMessagePeopleListBinding inflate = ActivityMessagePeopleListBinding.inflate(getLayoutInflater());
        this.messagePeopleListBinding = inflate;
        RelativeLayout root = inflate.getRoot();
        setContentView((View) root);
        this.auth = FirebaseAuth.getInstance();
        this.sharedPreferences = getSharedPreferences("com.mertcagliyan.pethox2.view", 0);
        this.mkullanicilar = new ArrayList<>();
        this.firebaseFirestore = FirebaseFirestore.getInstance();
        KullaniciOku();
        this.messagePeopleListBinding.usernameinmessage.setText(this.sharedPreferences.getString("username", (String) null));
        this.messagePeopleListBinding.recyclerViewArama.setLayoutManager(new LinearLayoutManager(this));
        this.kullaniciAdapter = new KullaniciAdapter(this.mkullanicilar);
        this.messagePeopleListBinding.recyclerViewArama.setAdapter(this.kullaniciAdapter);
        EditText editText = (EditText) root.findViewById(R.id.aramaBar);
        this.aramaBar = editText;
        editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                MessagePeopleList.this.Arama(charSequence.toString().toLowerCase());
            }
        });
    }

    /* access modifiers changed from: private */
    public void Arama(String str) {
        Query startAt = this.firebaseFirestore.collection("People").orderBy("usernameforsearch").startAt(str);
        startAt.endAt(str + "").addSnapshotListener(new EventListener<QuerySnapshot>() {
            public void onEvent(QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException) {
                MessagePeopleList.this.mkullanicilar.clear();
                for (DocumentSnapshot data : querySnapshot.getDocuments()) {
                    Map<String, Object> data2 = data.getData();
                    MessagePeopleList.this.mkullanicilar.add(new Kullanici((String) data2.get("username"), (String) data2.get("profilephoto")));
                }
                MessagePeopleList.this.kullaniciAdapter.notifyDataSetChanged();
            }
        });
    }

    private void KullaniciOku() {
        this.firebaseFirestore.collection("People").addSnapshotListener(new EventListener<QuerySnapshot>() {
            public void onEvent(QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException) {
                if (firebaseFirestoreException != null) {
                    Toast.makeText(MessagePeopleList.this, firebaseFirestoreException.getLocalizedMessage(), 0).show();
                }
                if (querySnapshot != null) {
                    if (MessagePeopleList.this.aramaBar.getText().toString().equals("")) {
                        MessagePeopleList.this.mkullanicilar.clear();
                        for (DocumentSnapshot data : querySnapshot.getDocuments()) {
                            Map<String, Object> data2 = data.getData();
                            MessagePeopleList.this.mkullanicilar.add(new Kullanici((String) data2.get("username"), (String) data2.get("profilephoto")));
                        }
                    }
                    MessagePeopleList.this.kullaniciAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    public void geritusu2(View view) {
        Intent intent = new Intent(this, SocialMediaActivity.class);
        intent.addFlags(67108864);
        startActivity(intent);
    }
}
