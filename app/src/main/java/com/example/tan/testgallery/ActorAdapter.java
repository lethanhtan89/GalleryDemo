package com.example.tan.testgallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Tan on 2/22/2018.
 */

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {
    private Context context;
    private ArrayList<Actor> actorArrayList;
    private ActorListener actorListener;

    public ActorAdapter(Context context, ArrayList<Actor> actorArrayList, ActorListener actorListener) {
        this.context = context;
        this.actorArrayList = actorArrayList;
        this.actorListener = actorListener;
    }

    @Override
    public ActorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ActorViewHolder(LayoutInflater.from(context).inflate(R.layout.item_actor, parent, false));
    }

    @Override
    public void onBindViewHolder(ActorViewHolder holder, final int position) {
        Actor actor = actorArrayList.get(position);

        Picasso.with(context).load(actor.getUrl()).placeholder(R.drawable.img_no).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (actorListener != null) {
                    actorListener.onClickDetail(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return actorArrayList.size();
    }

    public class ActorViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ActorViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img_actor);
        }
    }
}
