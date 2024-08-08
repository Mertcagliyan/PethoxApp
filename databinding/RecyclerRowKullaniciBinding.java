package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;
import de.hdodenhof.circleimageview.CircleImageView;

public final class RecyclerRowKullaniciBinding implements ViewBinding {
    public final LinearLayout linearid;
    public final CircleImageView offline;
    public final CircleImageView online;
    public final CircleImageView resimkullanici;
    private final RelativeLayout rootView;
    public final TextView username;

    private RecyclerRowKullaniciBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, CircleImageView circleImageView, CircleImageView circleImageView2, CircleImageView circleImageView3, TextView textView) {
        this.rootView = relativeLayout;
        this.linearid = linearLayout;
        this.offline = circleImageView;
        this.online = circleImageView2;
        this.resimkullanici = circleImageView3;
        this.username = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RecyclerRowKullaniciBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RecyclerRowKullaniciBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.recycler_row_kullanici, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RecyclerRowKullaniciBinding bind(View view) {
        int i = R.id.linearid;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearid);
        if (linearLayout != null) {
            i = R.id.offline;
            CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.offline);
            if (circleImageView != null) {
                i = R.id.online;
                CircleImageView circleImageView2 = (CircleImageView) view.findViewById(R.id.online);
                if (circleImageView2 != null) {
                    i = R.id.resimkullanici;
                    CircleImageView circleImageView3 = (CircleImageView) view.findViewById(R.id.resimkullanici);
                    if (circleImageView3 != null) {
                        i = R.id.username;
                        TextView textView = (TextView) view.findViewById(R.id.username);
                        if (textView != null) {
                            return new RecyclerRowKullaniciBinding((RelativeLayout) view, linearLayout, circleImageView, circleImageView2, circleImageView3, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
