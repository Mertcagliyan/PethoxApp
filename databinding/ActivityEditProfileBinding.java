package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;

public final class ActivityEditProfileBinding implements ViewBinding {
    public final ImageView iconBack2;
    public final ImageView imageView12;
    public final ImageView imageView13;
    private final ConstraintLayout rootView;
    public final TextView textView12;

    private ActivityEditProfileBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView) {
        this.rootView = constraintLayout;
        this.iconBack2 = imageView;
        this.imageView12 = imageView2;
        this.imageView13 = imageView3;
        this.textView12 = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityEditProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityEditProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_edit_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityEditProfileBinding bind(View view) {
        int i = R.id.iconBack2;
        ImageView imageView = (ImageView) view.findViewById(R.id.iconBack2);
        if (imageView != null) {
            i = R.id.imageView12;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView12);
            if (imageView2 != null) {
                i = R.id.imageView13;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.imageView13);
                if (imageView3 != null) {
                    i = R.id.textView12;
                    TextView textView = (TextView) view.findViewById(R.id.textView12);
                    if (textView != null) {
                        return new ActivityEditProfileBinding((ConstraintLayout) view, imageView, imageView2, imageView3, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
