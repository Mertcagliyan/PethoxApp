package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;

public final class ActivityGizlilikSozlesmesiBinding implements ViewBinding {
    public final ImageView imageView17;
    public final CheckBox okudum;
    private final LinearLayout rootView;
    public final TextView textView16;
    public final TextView textView17;
    public final TextView textView18;
    public final TextView textView19;
    public final TextView textView20;
    public final TextView textView21;
    public final TextView textView22;
    public final TextView textView23;
    public final TextView textView24;
    public final TextView textView25;
    public final TextView textView26;
    public final TextView textView27;

    private ActivityGizlilikSozlesmesiBinding(LinearLayout linearLayout, ImageView imageView, CheckBox checkBox, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = linearLayout;
        this.imageView17 = imageView;
        this.okudum = checkBox;
        this.textView16 = textView;
        this.textView17 = textView2;
        this.textView18 = textView3;
        this.textView19 = textView4;
        this.textView20 = textView5;
        this.textView21 = textView6;
        this.textView22 = textView7;
        this.textView23 = textView8;
        this.textView24 = textView9;
        this.textView25 = textView10;
        this.textView26 = textView11;
        this.textView27 = textView12;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityGizlilikSozlesmesiBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityGizlilikSozlesmesiBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_gizlilik_sozlesmesi, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityGizlilikSozlesmesiBinding bind(View view) {
        View view2 = view;
        int i = R.id.imageView17;
        ImageView imageView = (ImageView) view2.findViewById(R.id.imageView17);
        if (imageView != null) {
            i = R.id.okudum;
            CheckBox checkBox = (CheckBox) view2.findViewById(R.id.okudum);
            if (checkBox != null) {
                i = R.id.textView16;
                TextView textView = (TextView) view2.findViewById(R.id.textView16);
                if (textView != null) {
                    i = R.id.textView17;
                    TextView textView2 = (TextView) view2.findViewById(R.id.textView17);
                    if (textView2 != null) {
                        i = R.id.textView18;
                        TextView textView3 = (TextView) view2.findViewById(R.id.textView18);
                        if (textView3 != null) {
                            i = R.id.textView19;
                            TextView textView4 = (TextView) view2.findViewById(R.id.textView19);
                            if (textView4 != null) {
                                i = R.id.textView20;
                                TextView textView5 = (TextView) view2.findViewById(R.id.textView20);
                                if (textView5 != null) {
                                    i = R.id.textView21;
                                    TextView textView6 = (TextView) view2.findViewById(R.id.textView21);
                                    if (textView6 != null) {
                                        i = R.id.textView22;
                                        TextView textView7 = (TextView) view2.findViewById(R.id.textView22);
                                        if (textView7 != null) {
                                            i = R.id.textView23;
                                            TextView textView8 = (TextView) view2.findViewById(R.id.textView23);
                                            if (textView8 != null) {
                                                i = R.id.textView24;
                                                TextView textView9 = (TextView) view2.findViewById(R.id.textView24);
                                                if (textView9 != null) {
                                                    i = R.id.textView25;
                                                    TextView textView10 = (TextView) view2.findViewById(R.id.textView25);
                                                    if (textView10 != null) {
                                                        i = R.id.textView26;
                                                        TextView textView11 = (TextView) view2.findViewById(R.id.textView26);
                                                        if (textView11 != null) {
                                                            i = R.id.textView27;
                                                            TextView textView12 = (TextView) view2.findViewById(R.id.textView27);
                                                            if (textView12 != null) {
                                                                return new ActivityGizlilikSozlesmesiBinding((LinearLayout) view2, imageView, checkBox, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
