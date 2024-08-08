package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;

public final class ActivityPremiumHesapBinding implements ViewBinding {
    public final ImageView iconBack3;
    public final ImageView imageView15;
    public final EditText kodText;
    public final ImageView onaylabutonu;
    private final ConstraintLayout rootView;
    public final TextView textView13;
    public final TextView textView14;

    private ActivityPremiumHesapBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, EditText editText, ImageView imageView3, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.iconBack3 = imageView;
        this.imageView15 = imageView2;
        this.kodText = editText;
        this.onaylabutonu = imageView3;
        this.textView13 = textView;
        this.textView14 = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPremiumHesapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPremiumHesapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_premium_hesap, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityPremiumHesapBinding bind(View view) {
        int i = R.id.iconBack3;
        ImageView imageView = (ImageView) view.findViewById(R.id.iconBack3);
        if (imageView != null) {
            i = R.id.imageView15;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView15);
            if (imageView2 != null) {
                i = R.id.kodText;
                EditText editText = (EditText) view.findViewById(R.id.kodText);
                if (editText != null) {
                    i = R.id.onaylabutonu;
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.onaylabutonu);
                    if (imageView3 != null) {
                        i = R.id.textView13;
                        TextView textView = (TextView) view.findViewById(R.id.textView13);
                        if (textView != null) {
                            i = R.id.textView14;
                            TextView textView2 = (TextView) view.findViewById(R.id.textView14);
                            if (textView2 != null) {
                                return new ActivityPremiumHesapBinding((ConstraintLayout) view, imageView, imageView2, editText, imageView3, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
