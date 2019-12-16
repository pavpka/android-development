package com.example.lab6.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab6.R


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
//        (activity as AppCompatActivity).supportActionBar!!.setTitle("Home")
        return view
    }
}