package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mertcagliyan.pethox2.R;

public final class ActivitySocialMediaBinding implements ViewBinding {
    public final BottomNavigationView bottomNavigationView;
    public final FrameLayout frameLayout;
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;
    public final Toolbar toolbar;

    private ActivitySocialMediaBinding(RelativeLayout relativeLayout, BottomNavigationView bottomNavigationView2, FrameLayout frameLayout2, RecyclerView recyclerView2, Toolbar toolbar2) {
        this.rootView = relativeLayout;
        this.bottomNavigationView = bottomNavigationView2;
        this.frameLayout = frameLayout2;
        this.recyclerView = recyclerView2;
        this.toolbar = toolbar2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySocialMediaBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivitySocialMediaBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_social_media, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySocialMediaBinding bind(View view) {
        int i = R.id.bottom_navigationView;
        BottomNavigationView bottomNavigationView2 = (BottomNavigationView) view.findViewById(R.id.bottom_navigationView);
        if (bottomNavigationView2 != null) {
            i = R.id.frame_layout;
            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.frame_layout);
            if (frameLayout2 != null) {
                i = R.id.recyclerView;
                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView);
                if (recyclerView2 != null) {
                    i = R.id.toolbar;
                    Toolbar toolbar2 = (Toolbar) view.findViewById(R.id.toolbar);
                    if (toolbar2 != null) {
                        return new ActivitySocialMediaBinding((RelativeLayout) view, bottomNavigationView2, frameLayout2, recyclerView2, toolbar2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
