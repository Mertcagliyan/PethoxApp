package com.mertcagliyan.pethox2.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mertcagliyan.pethox2.Model.Post;
import com.mertcagliyan.pethox2.R;
import com.mertcagliyan.pethox2.databinding.LayoutAdBinding;
import com.mertcagliyan.pethox2.databinding.RecyclerRowBinding;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int AD_VIEW = 1;
    private static final int ITEM_FEED_COUNT = 6;
    private static final int ITEM_VIEW = 0;
    /* access modifiers changed from: private */
    public final Activity activity;
    /* access modifiers changed from: private */
    public FirebaseAuth auth;
    /* access modifiers changed from: private */
    public DocumentReference documentReference;
    /* access modifiers changed from: private */
    public FirebaseFirestore firebaseFirestore;
    private final ArrayList<Post> postArrayList;

    public PostAdapter(Activity activity2, ArrayList<Post> arrayList) {
        this.activity = activity2;
        this.postArrayList = arrayList;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(this.activity);
        if (i == 0) {
            return new PostHolder(from.inflate(R.layout.recycler_row, viewGroup, false));
        }
        if (i == 1) {
            return new AdViewHolder(from.inflate(R.layout.layout_ad, viewGroup, false));
        }
        return null;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType() == 0) {
            int round = i - Math.round((float) (i / 6));
            PostHolder postHolder = (PostHolder) viewHolder;
            postHolder.recyclerRowBinding.recyclerViewCommentText.setText(this.postArrayList.get(round).comment);
            postHolder.recyclerRowBinding.recyclerViewUsername.setText(this.postArrayList.get(round).userName);
            Picasso.get().load(this.postArrayList.get(round).profilePhoto).into((ImageView) postHolder.recyclerRowBinding.recyclerViewProfilePhoto);
            Picasso.get().load(this.postArrayList.get(round).downloadUrl).resize(390, 390).centerCrop().into(postHolder.recyclerRowBinding.recyclerViewImageView);
        } else if (viewHolder.getItemViewType() == 1) {
            ((AdViewHolder) viewHolder).bindAdData();
        }
    }

    public int getItemCount() {
        if (this.postArrayList.size() > 0) {
            return this.postArrayList.size() + Math.round((float) (this.postArrayList.size() / 6));
        }
        return this.postArrayList.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {
        RecyclerRowBinding recyclerRowBinding;

        public PostHolder(View view) {
            super(view);
            this.recyclerRowBinding = RecyclerRowBinding.bind(view);
        }
    }

    public int getItemViewType(int i) {
        return (i + 1) % 6 == 0 ? 1 : 0;
    }

    public class AdViewHolder extends RecyclerView.ViewHolder {
        LayoutAdBinding binding;

        public AdViewHolder(View view) {
            super(view);
            this.binding = LayoutAdBinding.bind(view);
        }

        /* access modifiers changed from: private */
        public void bindAdData() {
            new AdLoader.Builder(PostAdapter.this.activity, "ca-app-pub-7745528178947204/1278245858").forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                public void onNativeAdLoaded(NativeAd nativeAd) {
                    final NativeAdView nativeAdView = (NativeAdView) PostAdapter.this.activity.getLayoutInflater().inflate(R.layout.layout_native_ad, (ViewGroup) null);
                    PostAdapter.this.populateNativeADView(nativeAd, nativeAdView);
                    AdViewHolder.this.binding.adLayout.removeAllViews();
                    FirebaseFirestore unused = PostAdapter.this.firebaseFirestore = FirebaseFirestore.getInstance();
                    FirebaseAuth unused2 = PostAdapter.this.auth = FirebaseAuth.getInstance();
                    DocumentReference unused3 = PostAdapter.this.documentReference = PostAdapter.this.firebaseFirestore.collection("People").document(PostAdapter.this.auth.getUid());
                    PostAdapter.this.documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if (documentSnapshot.exists() && documentSnapshot.getData().get("premium").toString().equals("inaktif")) {
                                AdViewHolder.this.binding.adLayout.addView(nativeAdView);
                            }
                        }
                    });
                }
            }).withAdListener(new AdListener() {
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                }
            }).build().loadAd(new AdRequest.Builder().build());
        }
    }

    /* access modifiers changed from: private */
    public void populateNativeADView(NativeAd nativeAd, NativeAdView nativeAdView) {
        nativeAdView.setMediaView((MediaView) nativeAdView.findViewById(R.id.ad_media));
        nativeAdView.setHeadlineView(nativeAdView.findViewById(R.id.ad_headline));
        nativeAdView.setBodyView(nativeAdView.findViewById(R.id.ad_body));
        nativeAdView.setCallToActionView(nativeAdView.findViewById(R.id.ad_call_to_action));
        nativeAdView.setIconView(nativeAdView.findViewById(R.id.ad_app_icon));
        nativeAdView.setPriceView(nativeAdView.findViewById(R.id.ad_price));
        nativeAdView.setStarRatingView(nativeAdView.findViewById(R.id.ad_stars));
        nativeAdView.setStoreView(nativeAdView.findViewById(R.id.ad_store));
        nativeAdView.setAdvertiserView(nativeAdView.findViewById(R.id.ad_advertiser));
        ((TextView) nativeAdView.getHeadlineView()).setText(nativeAd.getHeadline());
        nativeAdView.getMediaView().setMediaContent(nativeAd.getMediaContent());
        if (nativeAd.getBody() == null) {
            nativeAdView.getBodyView().setVisibility(4);
        } else {
            nativeAdView.getBodyView().setVisibility(0);
            ((TextView) nativeAdView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            nativeAdView.getCallToActionView().setVisibility(4);
        } else {
            nativeAdView.getCallToActionView().setVisibility(0);
            ((Button) nativeAdView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            nativeAdView.getIconView().setVisibility(8);
        } else {
            ((ImageView) nativeAdView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            nativeAdView.getIconView().setVisibility(0);
        }
        if (nativeAd.getPrice() == null) {
            nativeAdView.getPriceView().setVisibility(4);
        } else {
            nativeAdView.getPriceView().setVisibility(0);
            ((TextView) nativeAdView.getPriceView()).setText(nativeAd.getPrice());
        }
        if (nativeAd.getStore() == null) {
            nativeAdView.getStoreView().setVisibility(4);
        } else {
            nativeAdView.getStoreView().setVisibility(0);
            ((TextView) nativeAdView.getStoreView()).setText(nativeAd.getStore());
        }
        if (nativeAd.getStarRating() == null) {
            nativeAdView.getStarRatingView().setVisibility(4);
        } else {
            ((RatingBar) nativeAdView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            nativeAdView.getStarRatingView().setVisibility(0);
        }
        if (nativeAd.getAdvertiser() == null) {
            nativeAdView.getAdvertiserView().setVisibility(4);
        } else {
            ((TextView) nativeAdView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            nativeAdView.getAdvertiserView().setVisibility(0);
        }
        nativeAdView.setNativeAd(nativeAd);
    }
}
