package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.mertcagliyan.pethox2.R;

public final class LayoutNativeAdBinding implements ViewBinding {
    public final TextView adAdvertiser;
    public final ImageView adAppIcon;
    public final TextView adBody;
    public final Button adCallToAction;
    public final TextView adHeadline;
    public final MediaView adMedia;
    public final TextView adPrice;
    public final RatingBar adStars;
    public final TextView adStore;
    private final NativeAdView rootView;

    private LayoutNativeAdBinding(NativeAdView nativeAdView, TextView textView, ImageView imageView, TextView textView2, Button button, TextView textView3, MediaView mediaView, TextView textView4, RatingBar ratingBar, TextView textView5) {
        this.rootView = nativeAdView;
        this.adAdvertiser = textView;
        this.adAppIcon = imageView;
        this.adBody = textView2;
        this.adCallToAction = button;
        this.adHeadline = textView3;
        this.adMedia = mediaView;
        this.adPrice = textView4;
        this.adStars = ratingBar;
        this.adStore = textView5;
    }

    public NativeAdView getRoot() {
        return this.rootView;
    }

    public static LayoutNativeAdBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutNativeAdBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_native_ad, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutNativeAdBinding bind(View view) {
        int i = R.id.ad_advertiser;
        TextView textView = (TextView) view.findViewById(R.id.ad_advertiser);
        if (textView != null) {
            i = R.id.ad_app_icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.ad_app_icon);
            if (imageView != null) {
                i = R.id.ad_body;
                TextView textView2 = (TextView) view.findViewById(R.id.ad_body);
                if (textView2 != null) {
                    i = R.id.ad_call_to_action;
                    Button button = (Button) view.findViewById(R.id.ad_call_to_action);
                    if (button != null) {
                        i = R.id.ad_headline;
                        TextView textView3 = (TextView) view.findViewById(R.id.ad_headline);
                        if (textView3 != null) {
                            i = R.id.ad_media;
                            MediaView mediaView = (MediaView) view.findViewById(R.id.ad_media);
                            if (mediaView != null) {
                                i = R.id.ad_price;
                                TextView textView4 = (TextView) view.findViewById(R.id.ad_price);
                                if (textView4 != null) {
                                    i = R.id.ad_stars;
                                    RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ad_stars);
                                    if (ratingBar != null) {
                                        i = R.id.ad_store;
                                        TextView textView5 = (TextView) view.findViewById(R.id.ad_store);
                                        if (textView5 != null) {
                                            return new LayoutNativeAdBinding((NativeAdView) view, textView, imageView, textView2, button, textView3, mediaView, textView4, ratingBar, textView5);
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
