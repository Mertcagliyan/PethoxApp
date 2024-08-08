package com.mertcagliyan.pethox2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.mertcagliyan.pethox2.R;

public final class ActivityMessagePeopleListBinding implements ViewBinding {
    public final EditText aramaBar;
    public final ImageButton geritusu2;
    public final LinearLayout linear;
    public final LinearLayout linear2;
    public final RecyclerView recyclerViewArama;
    private final RelativeLayout rootView;
    public final TextView usernameinmessage;

    private ActivityMessagePeopleListBinding(RelativeLayout relativeLayout, EditText editText, ImageButton imageButton, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView) {
        this.rootView = relativeLayout;
        this.aramaBar = editText;
        this.geritusu2 = imageButton;
        this.linear = linearLayout;
        this.linear2 = linearLayout2;
        this.recyclerViewArama = recyclerView;
        this.usernameinmessage = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMessagePeopleListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMessagePeopleListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_message_people_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityMessagePeopleListBinding bind(View view) {
        int i = R.id.aramaBar;
        EditText editText = (EditText) view.findViewById(R.id.aramaBar);
        if (editText != null) {
            i = R.id.geritusu2;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.geritusu2);
            if (imageButton != null) {
                i = R.id.linear;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linear);
                if (linearLayout != null) {
                    i = R.id.linear2;
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.linear2);
                    if (linearLayout2 != null) {
                        i = R.id.recyclerViewArama;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewArama);
                        if (recyclerView != null) {
                            i = R.id.usernameinmessage;
                            TextView textView = (TextView) view.findViewById(R.id.usernameinmessage);
                            if (textView != null) {
                                return new ActivityMessagePeopleListBinding((RelativeLayout) view, editText, imageButton, linearLayout, linearLayout2, recyclerView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
