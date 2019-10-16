package com.example.myapplication.adapter;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.pojo.ItemList;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ImageViewHolder> {

    private final List<ItemList> images;
    MediaPlayer mediaPlayer;

    public ListAdapter(MediaPlayer mediaPlayer, List<ItemList> images) {
        this.mediaPlayer = mediaPlayer;
        this.images = images;
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;


        public ImageViewHolder(final MediaPlayer mediaPlayer, View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageList);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println(mediaPlayer.isPlaying());
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        try {
                            mediaPlayer.prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    mediaPlayer.start();
                }
            });
        }
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.activity_main, parent, false);
        return new ImageViewHolder(mediaPlayer, itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        ItemList itemList = images.get(position);
        System.out.println(itemList.getImageSrc());
        Picasso.get().load(itemList.getImageSrc()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }
}
