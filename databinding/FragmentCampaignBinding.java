package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;

public final class FragmentCampaignBinding implements ViewBinding {
    public final ImageView imageView4;
    public final ImageView imageView6;
    private final ConstraintLayout rootView;
    public final TextView textView10;

    private FragmentCampaignBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = constraintLayout;
        this.imageView4 = imageView;
        this.imageView6 = imageView2;
        this.textView10 = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCampaignBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentCampaignBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_campaign, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentCampaignBinding bind(View view) {
        int i = R.id.imageView4;
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView4);
        if (imageView != null) {
            i = R.id.imageView6;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView6);
            if (imageView2 != null) {
                i = R.id.textView10;
                TextView textView = (TextView) view.findViewById(R.id.textView10);
                if (textView != null) {
                    return new FragmentCampaignBinding((ConstraintLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
