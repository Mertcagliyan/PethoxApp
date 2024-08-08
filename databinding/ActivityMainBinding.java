package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;

public final class ActivityMainBinding implements ViewBinding {
    public final ImageView button;
    public final EditText emailText;
    public final ImageView imageView;
    public final EditText passwordText;
    private final ConstraintLayout rootView;
    public final ImageView signInButton;
    public final TextView textView2;

    private ActivityMainBinding(ConstraintLayout constraintLayout, ImageView imageView2, EditText editText, ImageView imageView3, EditText editText2, ImageView imageView4, TextView textView) {
        this.rootView = constraintLayout;
        this.button = imageView2;
        this.emailText = editText;
        this.imageView = imageView3;
        this.passwordText = editText2;
        this.signInButton = imageView4;
        this.textView2 = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMainBinding bind(View view) {
        int i = R.id.button;
        ImageView imageView2 = (ImageView) view.findViewById(R.id.button);
        if (imageView2 != null) {
            i = R.id.emailText;
            EditText editText = (EditText) view.findViewById(R.id.emailText);
            if (editText != null) {
                i = R.id.imageView;
                ImageView imageView3 = (ImageView) view.findViewById(R.id.imageView);
                if (imageView3 != null) {
                    i = R.id.passwordText;
                    EditText editText2 = (EditText) view.findViewById(R.id.passwordText);
                    if (editText2 != null) {
                        i = R.id.signInButton;
                        ImageView imageView4 = (ImageView) view.findViewById(R.id.signInButton);
                        if (imageView4 != null) {
                            i = R.id.textView2;
                            TextView textView = (TextView) view.findViewById(R.id.textView2);
                            if (textView != null) {
                                return new ActivityMainBinding((ConstraintLayout) view, imageView2, editText, imageView3, editText2, imageView4, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
