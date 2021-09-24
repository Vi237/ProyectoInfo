package com.vi.lavenganza20.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vi.lavenganza20.R;
import com.vi.lavenganza20.model.Image;
import com.vi.lavenganza20.view.ImageDetailActivity;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewFolder>{
    //lista de imagenes
    private ArrayList<Image>images;
    private int resource;
    private Activity activity;
    public CardViewAdapter(ArrayList<Image>images,int resource, Activity activity){
        this.images=images;
        this.resource=resource;
        this.activity=activity;
    }

    @NonNull
    @Override
    public CardViewFolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new CardViewFolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewFolder holder, int position) {
        Image image=images.get(position);
        //imagen libreria externa--image
        Picasso.get ().load (image.getUrlImagen()).into (holder.imageCardView);
        holder.usernameCardView.setText(image.getUsername());
        holder.cantidadDiasCardView.setText(image.getCantidadDiaz());
        holder.cantidadMeGustaCardView.setText(image.getCantidadMeGusta());
        //onclicklistener
        holder.imageCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(activity, ImageDetailActivity.class);
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode=new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity,view,activity.getString(R.string.transitionName_imageCardView)).toBundle());
                }else {
                    activity.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class CardViewFolder extends RecyclerView.ViewHolder{
        private ImageView imageCardView;
        private TextView usernameCardView;
        private TextView cantidadDiasCardView;
        private TextView cantidadMeGustaCardView;
        public CardViewFolder(@NonNull View itemView) {
            super(itemView);
            imageCardView=itemView.findViewById(R.id.imageCardView);
            usernameCardView=itemView.findViewById(R.id.usernameCardView);
            cantidadDiasCardView=itemView.findViewById(R.id.cantidadDiasCardView);
            cantidadMeGustaCardView=itemView.findViewById(R.id.cantidadMeGustaCardView);
        }
    }
}
