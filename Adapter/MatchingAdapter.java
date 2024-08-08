package com.mertcagliyan.pethox2.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mertcagliyan.pethox2.Model.MatchingPet;
import com.mertcagliyan.pethox2.databinding.RecyclerRowForMatchingPetBinding;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class MatchingAdapter extends RecyclerView.Adapter<MatchingHolder> {
    private ArrayList<MatchingPet> petArrayList;

    public MatchingAdapter(ArrayList<MatchingPet> arrayList) {
        this.petArrayList = arrayList;
    }

    public MatchingHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MatchingHolder(RecyclerRowForMatchingPetBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public void onBindViewHolder(MatchingHolder matchingHolder, int i) {
        TextView textView = matchingHolder.recyclerRowForMatching.recyclerViewPetName;
        textView.setText("Tür: " + this.petArrayList.get(i).petName);
        matchingHolder.recyclerRowForMatching.recyclerViewUsername2.setText(this.petArrayList.get(i).userName);
        TextView textView2 = matchingHolder.recyclerRowForMatching.recyclerViewPetAge;
        textView2.setText("Yaş: " + this.petArrayList.get(i).petAge);
        TextView textView3 = matchingHolder.recyclerRowForMatching.recyclerViewPetGender;
        textView3.setText("Cinsiyet: " + this.petArrayList.get(i).gender);
        TextView textView4 = matchingHolder.recyclerRowForMatching.recyclerViewPetSpecies;
        textView4.setText("Cins: " + this.petArrayList.get(i).petSpecie);
        Picasso.get().load(this.petArrayList.get(i).profilePhoto).into((ImageView) matchingHolder.recyclerRowForMatching.recyclerViewProfilePhoto);
        Picasso.get().load(this.petArrayList.get(i).downloadUrl).into(matchingHolder.recyclerRowForMatching.recyclerViewPhoto2);
    }

    public int getItemCount() {
        return this.petArrayList.size();
    }

    class MatchingHolder extends RecyclerView.ViewHolder {
        RecyclerRowForMatchingPetBinding recyclerRowForMatching;

        public MatchingHolder(RecyclerRowForMatchingPetBinding recyclerRowForMatchingPetBinding) {
            super(recyclerRowForMatchingPetBinding.getRoot());
            this.recyclerRowForMatching = recyclerRowForMatchingPetBinding;
        }
    }
}
