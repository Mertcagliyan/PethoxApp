package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;
import de.hdodenhof.circleimageview.CircleImageView;

public final class ActivityMessageBinding implements ViewBinding {
    public final ImageView fotoekle;
    public final ImageButton geritusu;
    public final ImageView gonder;
    public final TextView kullaniciAdi;
    public final EditText mesajgirdi;
    public final CircleImageView profilresim;
    public final RecyclerView recyclerViewMessage;
    public final RelativeLayout relative;
    private final RelativeLayout rootView;
    public final LinearLayout toolbar;

    private ActivityMessageBinding(RelativeLayout relativeLayout, ImageView imageView, ImageButton imageButton, ImageView imageView2, TextView textView, EditText editText, CircleImageView circleImageView, RecyclerView recyclerView, RelativeLayout relativeLayout2, LinearLayout linearLayout) {
        this.rootView = relativeLayout;
        this.fotoekle = imageView;
        this.geritusu = imageButton;
        this.gonder = imageView2;
        this.kullaniciAdi = textView;
        this.mesajgirdi = editText;
        this.profilresim = circleImageView;
        this.recyclerViewMessage = recyclerView;
        this.relative = relativeLayout2;
        this.toolbar = linearLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_message, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMessageBinding bind(View view) {
        int i = R.id.fotoekle;
        ImageView imageView = (ImageView) view.findViewById(R.id.fotoekle);
        if (imageView != null) {
            i = R.id.geritusu;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.geritusu);
            if (imageButton != null) {
                i = R.id.gonder;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.gonder);
                if (imageView2 != null) {
                    i = R.id.kullaniciAdi;
                    TextView textView = (TextView) view.findViewById(R.id.kullaniciAdi);
                    if (textView != null) {
                        i = R.id.mesajgirdi;
                        EditText editText = (EditText) view.findViewById(R.id.mesajgirdi);
                        if (editText != null) {
                            i = R.id.profilresim;
                            CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.profilresim);
                            if (circleImageView != null) {
                                i = R.id.recyclerViewMessage;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMessage);
                                if (recyclerView != null) {
                                    i = R.id.relative;
                                    RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.relative);
                                    if (relativeLayout != null) {
                                        i = R.id.toolbar;
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.toolbar);
                                        if (linearLayout != null) {
                                            return new ActivityMessageBinding((RelativeLayout) view, imageView, imageButton, imageView2, textView, editText, circleImageView, recyclerView, relativeLayout, linearLayout);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
