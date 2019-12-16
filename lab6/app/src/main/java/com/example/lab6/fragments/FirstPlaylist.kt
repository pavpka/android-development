package com.example.lab6.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.R
import com.example.lab6.adapter.RecyclerViewAdapter
import com.example.lab6.data.YoutubeVideo


class FirstPlaylist : Fragment() {
    companion object {
        fun newInstance(): FirstPlaylist {
            val firstPlaylistFragment = FirstPlaylist()
            val bundle = Bundle()
            firstPlaylistFragment.arguments = bundle

            return firstPlaylistFragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_playlist, container, false
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 1)
        recyclerView.layoutManager = layoutManager
        val adapter = RecyclerViewAdapter(YoutubeVideo.initFirstPlaylist())
        recyclerView.adapter = adapter

        (activity as AppCompatActivity).supportActionBar!!.setTitle("Playlist #1")
        return view
    }
}