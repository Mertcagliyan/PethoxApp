package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;
import de.hdodenhof.circleimageview.CircleImageView;

public final class RecyclerRowBinding implements ViewBinding {
    public final ImageView imageView16;
    public final TextView recyclerViewCommentText;
    public final ImageView recyclerViewImageView;
    public final CircleImageView recyclerViewProfilePhoto;
    public final TextView recyclerViewUsername;
    private final ConstraintLayout rootView;

    private RecyclerRowBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ImageView imageView2, CircleImageView circleImageView, TextView textView2) {
        this.rootView = constraintLayout;
        this.imageView16 = imageView;
        this.recyclerViewCommentText = textView;
        this.recyclerViewImageView = imageView2;
        this.recyclerViewProfilePhoto = circleImageView;
        this.recyclerViewUsername = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RecyclerRowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RecyclerRowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.recycler_row, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RecyclerRowBinding bind(View view) {
        int i = R.id.imageView16;
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView16);
        if (imageView != null) {
            i = R.id.recyclerViewCommentText;
            TextView textView = (TextView) view.findViewById(R.id.recyclerViewCommentText);
            if (textView != null) {
                i = R.id.recyclerViewImageView;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.recyclerViewImageView);
                if (imageView2 != null) {
                    i = R.id.recyclerViewProfilePhoto;
                    CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.recyclerViewProfilePhoto);
                    if (circleImageView != null) {
                        i = R.id.recyclerViewUsername;
                        TextView textView2 = (TextView) view.findViewById(R.id.recyclerViewUsername);
                        if (textView2 != null) {
                            return new RecyclerRowBinding((ConstraintLayout) view, imageView, textView, imageView2, circleImageView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
