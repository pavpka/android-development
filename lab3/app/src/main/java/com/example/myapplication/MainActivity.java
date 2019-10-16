package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.media.MediaPlayer;
import android.os.Bundle;

import com.example.myapplication.adapter.ListAdapter;
import com.example.myapplication.pojo.ItemList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,1);
        recyclerView.setLayoutManager(layoutManager);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sound);
        RecyclerView.Adapter adapter = new ListAdapter(mediaPlayer, ItemList.generateImages());
        recyclerView.setAdapter(adapter);

    }
}
