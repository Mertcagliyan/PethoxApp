package com.mertcagliyan.pethox2.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mertcagliyan.pethox2.Model.Kullanici;
import com.mertcagliyan.pethox2.databinding.RecyclerRowKullaniciBinding;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class KullaniciAdapter extends RecyclerView.Adapter<KullaniciHolder> {
    private FirebaseUser mevcutkullanici = FirebaseAuth.getInstance().getCurrentUser();
    ArrayList<Kullanici> mkullanicilar;

    public KullaniciAdapter(ArrayList<Kullanici> arrayList) {
        this.mkullanicilar = arrayList;
    }

    public KullaniciHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new KullaniciHolder(RecyclerRowKullaniciBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    public void onBindViewHolder(KullaniciHolder kullaniciHolder, int i) {
        kullaniciHolder.recyclerRowKullaniciBinding.username.setText(this.mkullanicilar.get(i).username);
        Picasso.get().load(this.mkullanicilar.get(i).profilephoto).into((ImageView) kullaniciHolder.recyclerRowKullaniciBinding.resimkullanici);
    }

    public int getItemCount() {
        return this.mkullanicilar.size();
    }

    class KullaniciHolder extends RecyclerView.ViewHolder {
        RecyclerRowKullaniciBinding recyclerRowKullaniciBinding;

        public KullaniciHolder(RecyclerRowKullaniciBinding recyclerRowKullaniciBinding2) {
            super(recyclerRowKullaniciBinding2.getRoot());
            this.recyclerRowKullaniciBinding = recyclerRowKullaniciBinding2;
        }
    }
}
