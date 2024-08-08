package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;

public final class LayoutAdBinding implements ViewBinding {
    public final FrameLayout adLayout;
    private final ConstraintLayout rootView;

    private LayoutAdBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout) {
        this.rootView = constraintLayout;
        this.adLayout = frameLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutAdBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutAdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_ad, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutAdBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.adLayout);
        if (frameLayout != null) {
            return new LayoutAdBinding((ConstraintLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.adLayout)));
    }
}
