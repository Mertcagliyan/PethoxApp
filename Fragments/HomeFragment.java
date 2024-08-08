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
import com.mertcagliyan.pethox2.Adapter.PostAdapter;
import com.mertcagliyan.pethox2.Model.Post;
import com.mertcagliyan.pethox2.R;
import java.util.ArrayList;
import java.util.Map;

public class HomeFragment extends Fragment {
    FirebaseFirestore firebaseFirestore;
    /* access modifiers changed from: private */
    public PostAdapter postAdapter;
    /* access modifiers changed from: private */
    public ArrayList<Post> postArrayList;
    private RecyclerView recyclerView;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
        this.firebaseFirestore = FirebaseFirestore.getInstance();
        RecyclerView recyclerView2 = (RecyclerView) inflate.findViewById(R.id.recyclerViewHome);
        this.recyclerView = recyclerView2;
        recyclerView2.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.postArrayList = new ArrayList<>();
        PostAdapter postAdapter2 = new PostAdapter(getActivity(), this.postArrayList);
        this.postAdapter = postAdapter2;
        this.recyclerView.setAdapter(postAdapter2);
        getData();
        return inflate;
    }

    public void getData() {
        this.firebaseFirestore.collection("Posts").orderBy("date", Query.Direction.DESCENDING).addSnapshotListener(new EventListener<QuerySnapshot>() {
            public void onEvent(QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException) {
                if (querySnapshot != null) {
                    for (DocumentSnapshot data : querySnapshot.getDocuments()) {
                        Map<String, Object> data2 = data.getData();
                        HomeFragment.this.postArrayList.add(new Post((String) data2.get("comment"), (String) data2.get("downloadurl"), (String) data2.get("username"), (String) data2.get("profilephoto")));
                    }
                    HomeFragment.this.postAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
