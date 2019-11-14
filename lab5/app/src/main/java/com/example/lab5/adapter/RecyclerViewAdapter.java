package com.example.lab5.adapter;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab5.R;
import com.example.lab5.pojo.ItemList;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CardViewHolder> {

    private final List<ItemList> cards;

    public RecyclerViewAdapter(List<ItemList> cards) {
        this.cards = cards;
    }

    static class CardViewHolder extends RecyclerView.ViewHolder {
        final CardView cardView;
        final ImageView image;
        final TextView location;
        final TextView date;

        public CardViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.item_card);
            image = itemView.findViewById(R.id.imageList);
            location = itemView.findViewById(R.id.image_location);
            date = itemView.findViewById(R.id.image_date);
        }
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        ItemList itemList = cards.get(position);
        Picasso.get().load(itemList.getImageSrc()).into(holder.image);
        holder.location.setText(cards.get(position).getLocation());
        holder.date.setText(cards.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }
}
