package com.example.lab6.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.data.YoutubeVideo
import com.google.android.youtube.player.*
import com.example.lab6.R

class RecyclerViewAdapter(val youtubeVideos: List<YoutubeVideo>) :
    RecyclerView.Adapter<RecyclerViewAdapter.VideoViewHolder>() {

    private lateinit var youTubePlayer: YouTubePlayer
    private lateinit var youTubePlayerFragment: YouTubePlayerFragment

    inner class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoContainer: RelativeLayout = itemView.findViewById(R.id.youtube_frame_layout)
        val videoView: YouTubeThumbnailView = itemView.findViewById(R.id.youtube_thumbnail)
        val videoTitle: TextView = itemView.findViewById(R.id.video_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return youtubeVideos.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {

    }


}