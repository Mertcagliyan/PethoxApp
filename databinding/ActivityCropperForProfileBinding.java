package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;
import java.util.Objects;

public final class ActivityCropperForProfileBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ActivityCropperForProfileBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCropperForProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityCropperForProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_cropper_for_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityCropperForProfileBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ActivityCropperForProfileBinding((ConstraintLayout) view);
    }
}
