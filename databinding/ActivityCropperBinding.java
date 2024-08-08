package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;

public final class ActivityCropperBinding implements ViewBinding {
    public final ImageView imageView14;
    private final ConstraintLayout rootView;

    private ActivityCropperBinding(ConstraintLayout constraintLayout, ImageView imageView) {
        this.rootView = constraintLayout;
        this.imageView14 = imageView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCropperBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityCropperBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_cropper, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityCropperBinding bind(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView14);
        if (imageView != null) {
            return new ActivityCropperBinding((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.imageView14)));
    }
}
