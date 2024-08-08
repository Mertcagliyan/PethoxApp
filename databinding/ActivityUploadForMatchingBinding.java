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

public final class ActivityUploadForMatchingBinding implements ViewBinding {
    public final ImageView IconBack2;
    public final EditText ageText;
    public final ImageView femaleText;
    public final ImageView femaleText2;
    public final TextView imageView7;
    public final ImageView imageView8;
    public final ImageView maleText;
    public final ImageView maleText2;
    public final EditText nameText;
    private final LinearLayout rootView;
    public final ImageView selectPet;
    public final EditText specieText;
    public final TextView textView6;
    public final TextView textView7;
    public final ImageView uploadButton2;

    private ActivityUploadForMatchingBinding(LinearLayout linearLayout, ImageView imageView, EditText editText, ImageView imageView2, ImageView imageView3, TextView textView, ImageView imageView4, ImageView imageView5, ImageView imageView6, EditText editText2, ImageView imageView9, EditText editText3, TextView textView2, TextView textView3, ImageView imageView10) {
        this.rootView = linearLayout;
        this.IconBack2 = imageView;
        this.ageText = editText;
        this.femaleText = imageView2;
        this.femaleText2 = imageView3;
        this.imageView7 = textView;
        this.imageView8 = imageView4;
        this.maleText = imageView5;
        this.maleText2 = imageView6;
        this.nameText = editText2;
        this.selectPet = imageView9;
        this.specieText = editText3;
        this.textView6 = textView2;
        this.textView7 = textView3;
        this.uploadButton2 = imageView10;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUploadForMatchingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityUploadForMatchingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_upload_for_matching, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityUploadForMatchingBinding bind(View view) {
        View view2 = view;
        int i = R.id.IconBack2;
        ImageView imageView = (ImageView) view2.findViewById(R.id.IconBack2);
        if (imageView != null) {
            i = R.id.ageText;
            EditText editText = (EditText) view2.findViewById(R.id.ageText);
            if (editText != null) {
                i = R.id.femaleText;
                ImageView imageView2 = (ImageView) view2.findViewById(R.id.femaleText);
                if (imageView2 != null) {
                    i = R.id.femaleText2;
                    ImageView imageView3 = (ImageView) view2.findViewById(R.id.femaleText2);
                    if (imageView3 != null) {
                        i = R.id.imageView7;
                        TextView textView = (TextView) view2.findViewById(R.id.imageView7);
                        if (textView != null) {
                            i = R.id.imageView8;
                            ImageView imageView4 = (ImageView) view2.findViewById(R.id.imageView8);
                            if (imageView4 != null) {
                                i = R.id.maleText;
                                ImageView imageView5 = (ImageView) view2.findViewById(R.id.maleText);
                                if (imageView5 != null) {
                                    i = R.id.maleText2;
                                    ImageView imageView6 = (ImageView) view2.findViewById(R.id.maleText2);
                                    if (imageView6 != null) {
                                        i = R.id.nameText;
                                        EditText editText2 = (EditText) view2.findViewById(R.id.nameText);
                                        if (editText2 != null) {
                                            i = R.id.selectPet;
                                            ImageView imageView9 = (ImageView) view2.findViewById(R.id.selectPet);
                                            if (imageView9 != null) {
                                                i = R.id.specieText;
                                                EditText editText3 = (EditText) view2.findViewById(R.id.specieText);
                                                if (editText3 != null) {
                                                    i = R.id.textView6;
                                                    TextView textView2 = (TextView) view2.findViewById(R.id.textView6);
                                                    if (textView2 != null) {
                                                        i = R.id.textView7;
                                                        TextView textView3 = (TextView) view2.findViewById(R.id.textView7);
                                                        if (textView3 != null) {
                                                            i = R.id.uploadButton2;
                                                            ImageView imageView10 = (ImageView) view2.findViewById(R.id.uploadButton2);
                                                            if (imageView10 != null) {
                                                                return new ActivityUploadForMatchingBinding((LinearLayout) view2, imageView, editText, imageView2, imageView3, textView, imageView4, imageView5, imageView6, editText2, imageView9, editText3, textView2, textView3, imageView10);
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
