package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;
import java.util.Objects;

public final class ActivityCropperForMatchingBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ActivityCropperForMatchingBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCropperForMatchingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityCropperForMatchingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_cropper_for_matching, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityCropperForMatchingBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new ActivityCropperForMatchingBinding((ConstraintLayout) view);
    }
}
