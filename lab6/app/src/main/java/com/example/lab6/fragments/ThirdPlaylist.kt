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


class ThirdPlaylist : Fragment() {
    companion object {
        fun newInstance(): ThirdPlaylist {
            val thirdPlaylistFragment = ThirdPlaylist()
            val bundle = Bundle()
            thirdPlaylistFragment.arguments = bundle

            return thirdPlaylistFragment
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
        val adapter =
            RecyclerViewAdapter(activity as AppCompatActivity, YoutubeVideo.initThirdPlaylist())
        recyclerView.adapter = adapter

        (activity as AppCompatActivity).supportActionBar!!.setTitle("Playlist #3")
        return view
    }
}