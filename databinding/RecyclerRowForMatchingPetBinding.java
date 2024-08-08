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

public final class RecyclerRowForMatchingPetBinding implements ViewBinding {
    public final ConstraintLayout constraintLayout;
    public final ImageView imageView16;
    public final TextView recyclerViewPetAge;
    public final TextView recyclerViewPetGender;
    public final TextView recyclerViewPetName;
    public final TextView recyclerViewPetSpecies;
    public final ImageView recyclerViewPhoto2;
    public final CircleImageView recyclerViewProfilePhoto;
    public final TextView recyclerViewUsername2;
    private final ConstraintLayout rootView;

    private RecyclerRowForMatchingPetBinding(ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView2, CircleImageView circleImageView, TextView textView5) {
        this.rootView = constraintLayout2;
        this.constraintLayout = constraintLayout3;
        this.imageView16 = imageView;
        this.recyclerViewPetAge = textView;
        this.recyclerViewPetGender = textView2;
        this.recyclerViewPetName = textView3;
        this.recyclerViewPetSpecies = textView4;
        this.recyclerViewPhoto2 = imageView2;
        this.recyclerViewProfilePhoto = circleImageView;
        this.recyclerViewUsername2 = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RecyclerRowForMatchingPetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RecyclerRowForMatchingPetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.recycler_row_for_matching_pet, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RecyclerRowForMatchingPetBinding bind(View view) {
        int i = R.id.constraintLayout;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.constraintLayout);
        if (constraintLayout2 != null) {
            i = R.id.imageView16;
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView16);
            if (imageView != null) {
                i = R.id.recyclerViewPetAge;
                TextView textView = (TextView) view.findViewById(R.id.recyclerViewPetAge);
                if (textView != null) {
                    i = R.id.recyclerViewPetGender;
                    TextView textView2 = (TextView) view.findViewById(R.id.recyclerViewPetGender);
                    if (textView2 != null) {
                        i = R.id.recyclerViewPetName;
                        TextView textView3 = (TextView) view.findViewById(R.id.recyclerViewPetName);
                        if (textView3 != null) {
                            i = R.id.recyclerViewPetSpecies;
                            TextView textView4 = (TextView) view.findViewById(R.id.recyclerViewPetSpecies);
                            if (textView4 != null) {
                                i = R.id.recyclerViewPhoto2;
                                ImageView imageView2 = (ImageView) view.findViewById(R.id.recyclerViewPhoto2);
                                if (imageView2 != null) {
                                    i = R.id.recyclerViewProfilePhoto;
                                    CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.recyclerViewProfilePhoto);
                                    if (circleImageView != null) {
                                        i = R.id.recyclerViewUsername2;
                                        TextView textView5 = (TextView) view.findViewById(R.id.recyclerViewUsername2);
                                        if (textView5 != null) {
                                            return new RecyclerRowForMatchingPetBinding((ConstraintLayout) view, constraintLayout2, imageView, textView, textView2, textView3, textView4, imageView2, circleImageView, textView5);
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
