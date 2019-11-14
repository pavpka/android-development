package com.example.lab5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab5.adapter.RecyclerViewAdapter;
import com.example.lab5.pojo.ItemList;


public class GalleryFragment extends Fragment {


    public static GalleryFragment newInstance() {
        GalleryFragment galleryFragment = new GalleryFragment();
        Bundle bundle = new Bundle();
        galleryFragment.setArguments(bundle);

        return galleryFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery,
                container, false);


        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new RecyclerViewAdapter(ItemList.initCards());
        recyclerView.setAdapter(adapter);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.gallery);
        return view;
    }
}
