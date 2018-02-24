package com.example.tan.testgallery;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Tan on 2/24/2018.
 */

public class DetailActorFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_actor, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        ImageView imgActor = (ImageView) view.findViewById(R.id.img_detail);
        Actor actor = (Actor) getArguments().getSerializable(Constant.TAG_DETAIL);
        Glide.with(getContext()).load(actor.getUrl()).into(imgActor);
    }
}
