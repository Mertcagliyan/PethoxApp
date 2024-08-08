package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;
import de.hdodenhof.circleimageview.CircleImageView;

public final class FragmentProfileBinding implements ViewBinding {
    public final CircleImageView Photoinprofile;
    public final ImageView dZenle;
    public final ImageView premium;
    public final ImageView premiumagecis;
    public final TextView profileEmail;
    public final TextView profileUsername;
    public final TextView profilfotosu;
    private final LinearLayout rootView;
    public final TextView textView11;
    public final TextView textView8;
    public final TextView textView9;

    private FragmentProfileBinding(LinearLayout linearLayout, CircleImageView circleImageView, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.Photoinprofile = circleImageView;
        this.dZenle = imageView;
        this.premium = imageView2;
        this.premiumagecis = imageView3;
        this.profileEmail = textView;
        this.profileUsername = textView2;
        this.profilfotosu = textView3;
        this.textView11 = textView4;
        this.textView8 = textView5;
        this.textView9 = textView6;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentProfileBinding bind(View view) {
        int i = R.id.Photoinprofile;
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.Photoinprofile);
        if (circleImageView != null) {
            i = R.id.f1dzenle;
            ImageView imageView = (ImageView) view.findViewById(R.id.f1dzenle);
            if (imageView != null) {
                i = R.id.premium;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.premium);
                if (imageView2 != null) {
                    i = R.id.premiumagecis;
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.premiumagecis);
                    if (imageView3 != null) {
                        i = R.id.profileEmail;
                        TextView textView = (TextView) view.findViewById(R.id.profileEmail);
                        if (textView != null) {
                            i = R.id.profileUsername;
                            TextView textView2 = (TextView) view.findViewById(R.id.profileUsername);
                            if (textView2 != null) {
                                i = R.id.profilfotosu;
                                TextView textView3 = (TextView) view.findViewById(R.id.profilfotosu);
                                if (textView3 != null) {
                                    i = R.id.textView11;
                                    TextView textView4 = (TextView) view.findViewById(R.id.textView11);
                                    if (textView4 != null) {
                                        i = R.id.textView8;
                                        TextView textView5 = (TextView) view.findViewById(R.id.textView8);
                                        if (textView5 != null) {
                                            i = R.id.textView9;
                                            TextView textView6 = (TextView) view.findViewById(R.id.textView9);
                                            if (textView6 != null) {
                                                return new FragmentProfileBinding((LinearLayout) view, circleImageView, imageView, imageView2, imageView3, textView, textView2, textView3, textView4, textView5, textView6);
                                            }
                                        }
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
