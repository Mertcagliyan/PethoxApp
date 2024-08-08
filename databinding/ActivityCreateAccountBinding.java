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
import de.hdodenhof.circleimageview.CircleImageView;

public final class ActivityCreateAccountBinding implements ViewBinding {
    public final ImageView button2;
    public final EditText emailText2;
    public final ImageView imageView3;
    public final EditText passwordText2;
    public final EditText premiumKod;
    public final CircleImageView profile;
    private final LinearLayout rootView;
    public final TextView textView3;
    public final EditText usernameText;

    private ActivityCreateAccountBinding(LinearLayout linearLayout, ImageView imageView, EditText editText, ImageView imageView2, EditText editText2, EditText editText3, CircleImageView circleImageView, TextView textView, EditText editText4) {
        this.rootView = linearLayout;
        this.button2 = imageView;
        this.emailText2 = editText;
        this.imageView3 = imageView2;
        this.passwordText2 = editText2;
        this.premiumKod = editText3;
        this.profile = circleImageView;
        this.textView3 = textView;
        this.usernameText = editText4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCreateAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityCreateAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_create_account, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityCreateAccountBinding bind(View view) {
        int i = R.id.button2;
        ImageView imageView = (ImageView) view.findViewById(R.id.button2);
        if (imageView != null) {
            i = R.id.emailText2;
            EditText editText = (EditText) view.findViewById(R.id.emailText2);
            if (editText != null) {
                i = R.id.imageView3;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView3);
                if (imageView2 != null) {
                    i = R.id.passwordText2;
                    EditText editText2 = (EditText) view.findViewById(R.id.passwordText2);
                    if (editText2 != null) {
                        i = R.id.premiumKod;
                        EditText editText3 = (EditText) view.findViewById(R.id.premiumKod);
                        if (editText3 != null) {
                            i = R.id.profile;
                            CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.profile);
                            if (circleImageView != null) {
                                i = R.id.textView3;
                                TextView textView = (TextView) view.findViewById(R.id.textView3);
                                if (textView != null) {
                                    i = R.id.usernameText;
                                    EditText editText4 = (EditText) view.findViewById(R.id.usernameText);
                                    if (editText4 != null) {
                                        return new ActivityCreateAccountBinding((LinearLayout) view, imageView, editText, imageView2, editText2, editText3, circleImageView, textView, editText4);
                                    }
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
