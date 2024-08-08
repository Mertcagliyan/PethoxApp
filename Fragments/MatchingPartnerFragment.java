package com.mertcagliyan.pethox2.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.mertcagliyan.pethox2.Adapter.MatchingAdapter;
import com.mertcagliyan.pethox2.Model.MatchingPet;
import com.mertcagliyan.pethox2.R;
import java.util.ArrayList;
import java.util.Map;

public class MatchingPartnerFragment extends Fragment {
    FirebaseFirestore firebaseFirestore;
    /* access modifiers changed from: private */
    public MatchingAdapter matchingAdapter;
    /* access modifiers changed from: private */
    public ArrayList<MatchingPet> petArrayList;
    private RecyclerView recyclerView;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_matching_partner, viewGroup, false);
        this.firebaseFirestore = FirebaseFirestore.getInstance();
        RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(R.id.recyclerViewMatching);
        this.recyclerView = recyclerView2;
        recyclerView2.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<MatchingPet> arrayList = new ArrayList<>();
        this.petArrayList = arrayList;
        MatchingAdapter matchingAdapter2 = new MatchingAdapter(arrayList);
        this.matchingAdapter = matchingAdapter2;
        this.recyclerView.setAdapter(matchingAdapter2);
        getData2();
        return inflate;
    }

    private void getData2() {
        this.firebaseFirestore.collection("Matching Pets").orderBy("date", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            public void onEvent(QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException) {
                if (querySnapshot != null) {
                    for (DocumentSnapshot data : querySnapshot.getDocuments()) {
                        Map<String, Object> data2 = data.getData();
                        String str = (String) data2.get("specietext");
                        String str2 = (String) data2.get("gender");
                        MatchingPartnerFragment.this.petArrayList.add(new MatchingPet((String) data2.get("username"), (String) data2.get("agetext"), (String) data2.get("nametext"), str, str2, (String) data2.get("profilephoto"), (String) data2.get("downloadurl")));
                    }
                    MatchingPartnerFragment.this.matchingAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
