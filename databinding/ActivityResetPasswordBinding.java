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

public final class ActivityResetPasswordBinding implements ViewBinding {
    public final ImageView editPassword;
    public final EditText editTextEmail;
    public final ImageView imageView18;
    public final ImageView imageView20;
    private final ConstraintLayout rootView;
    public final TextView textView15;

    private ActivityResetPasswordBinding(ConstraintLayout constraintLayout, ImageView imageView, EditText editText, ImageView imageView2, ImageView imageView3, TextView textView) {
        this.rootView = constraintLayout;
        this.editPassword = imageView;
        this.editTextEmail = editText;
        this.imageView18 = imageView2;
        this.imageView20 = imageView3;
        this.textView15 = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityResetPasswordBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityResetPasswordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_reset_password, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityResetPasswordBinding bind(View view) {
        int i = R.id.editPassword;
        ImageView imageView = (ImageView) view.findViewById(R.id.editPassword);
        if (imageView != null) {
            i = R.id.editTextEmail;
            EditText editText = (EditText) view.findViewById(R.id.editTextEmail);
            if (editText != null) {
                i = R.id.imageView18;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView18);
                if (imageView2 != null) {
                    i = R.id.imageView20;
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.imageView20);
                    if (imageView3 != null) {
                        i = R.id.textView15;
                        TextView textView = (TextView) view.findViewById(R.id.textView15);
                        if (textView != null) {
                            return new ActivityResetPasswordBinding((ConstraintLayout) view, imageView, editText, imageView2, imageView3, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
