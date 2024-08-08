package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;

public final class ActivityUploadBinding implements ViewBinding {
    public final ImageView IconBack;
    public final EditText commentText;
    public final ImageView imageView2;
    public final ImageView imageView5;
    private final LinearLayout rootView;
    public final TextView textView4;
    public final TextView textView5;
    public final ImageView uploadButton;

    private ActivityUploadBinding(LinearLayout linearLayout, ImageView imageView, EditText editText, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, ImageView imageView6) {
        this.rootView = linearLayout;
        this.IconBack = imageView;
        this.commentText = editText;
        this.imageView2 = imageView3;
        this.imageView5 = imageView4;
        this.textView4 = textView;
        this.textView5 = textView2;
        this.uploadButton = imageView6;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUploadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityUploadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_upload, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityUploadBinding bind(View view) {
        int i = R.id.IconBack;
        ImageView imageView = (ImageView) view.findViewById(R.id.IconBack);
        if (imageView != null) {
            i = R.id.commentText;
            EditText editText = (EditText) view.findViewById(R.id.commentText);
            if (editText != null) {
                i = R.id.imageView2;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.imageView2);
                if (imageView3 != null) {
                    i = R.id.imageView5;
                    ImageView imageView4 = (ImageView) view.findViewById(R.id.imageView5);
                    if (imageView4 != null) {
                        i = R.id.textView4;
                        TextView textView = (TextView) view.findViewById(R.id.textView4);
                        if (textView != null) {
                            i = R.id.textView5;
                            TextView textView2 = (TextView) view.findViewById(R.id.textView5);
                            if (textView2 != null) {
                                i = R.id.uploadButton;
                                ImageView imageView6 = (ImageView) view.findViewById(R.id.uploadButton);
                                if (imageView6 != null) {
                                    return new ActivityUploadBinding((LinearLayout) view, imageView, editText, imageView3, imageView4, textView, textView2, imageView6);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
