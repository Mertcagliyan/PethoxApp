package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;

public final class FragmentShelterBinding implements ViewBinding {
    public final ImageView imageView11;
    public final ImageView imageView9;
    private final ConstraintLayout rootView;
    public final TextView textView;

    private FragmentShelterBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView2) {
        this.rootView = constraintLayout;
        this.imageView11 = imageView;
        this.imageView9 = imageView2;
        this.textView = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentShelterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentShelterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_shelter, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentShelterBinding bind(View view) {
        int i = R.id.imageView11;
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView11);
        if (imageView != null) {
            i = R.id.imageView9;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView9);
            if (imageView2 != null) {
                i = R.id.textView;
                TextView textView2 = (TextView) view.findViewById(R.id.textView);
                if (textView2 != null) {
                    return new FragmentShelterBinding((ConstraintLayout) view, imageView, imageView2, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
