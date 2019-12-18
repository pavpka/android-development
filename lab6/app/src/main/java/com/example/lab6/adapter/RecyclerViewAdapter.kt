package com.example.lab6.adapter

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.lab6.BuildConfig
import com.example.lab6.R
import com.example.lab6.VideoService
import com.example.lab6.data.YoutubeVideo
import com.example.lab6.data.YoutubeVideoResponse
import com.google.android.youtube.player.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.google.android.youtube.player.YouTubeStandalonePlayer


class RecyclerViewAdapter(val ctx: Context, val youtubeVideos: List<YoutubeVideo>) :
    RecyclerView.Adapter<RecyclerViewAdapter.VideoInfoHolder>() {

    inner class VideoInfoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val youTubeFrameLayout: RelativeLayout =
            itemView.findViewById<View>(R.id.youtube_frame_layout) as RelativeLayout
        val youTubeThumbnailView: YouTubeThumbnailView =
            itemView.findViewById<View>(R.id.youtube_thumbnail) as YouTubeThumbnailView
        val playButton: ImageView =
            itemView.findViewById<View>(R.id.btn_youtube_player) as ImageView
        val videoTitle: TextView =
            itemView.findViewById(R.id.video_title) as TextView
        val progressBar: ProgressBar =
            itemView.findViewById<View>(R.id.progress_bar) as ProgressBar

    }

    private val apiService = VideoService.create()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoInfoHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return VideoInfoHolder(itemView)
    }

    override fun onBindViewHolder(holder: VideoInfoHolder, position: Int) {

        holder.youTubeThumbnailView.initialize(
            BuildConfig.YOUTUBE_API_KEY,
            object : YouTubeThumbnailView.OnInitializedListener {
                override fun onInitializationSuccess(
                    youTubeThumbnailView: YouTubeThumbnailView?,
                    youTubeThumbnailLoader: YouTubeThumbnailLoader
                ) {
                    youTubeThumbnailLoader.setVideo(youtubeVideos[position].id)
                    youTubeThumbnailLoader.setOnThumbnailLoadedListener(object :
                        YouTubeThumbnailLoader.OnThumbnailLoadedListener {
                        override fun onThumbnailError(
                            youTubeThumbnailView: YouTubeThumbnailView?,
                            errorReason: YouTubeThumbnailLoader.ErrorReason?
                        ) {
                            Log.d("ThumbnailError", errorReason.toString())
                        }

                        override fun onThumbnailLoaded(
                            youTubeThumbnailView: YouTubeThumbnailView,
                            strng: String?
                        ) {
                            youTubeThumbnailView.visibility = View.VISIBLE
                            holder.youTubeFrameLayout.visibility = View.VISIBLE
                            holder.playButton.visibility = View.VISIBLE
                            holder.progressBar.visibility = View.GONE
                        }
                    })
                }

                override fun onInitializationFailure(
                    youTubeThumbnailView: YouTubeThumbnailView?,
                    youTubeInitializationResult: YouTubeInitializationResult?
                ) {
                    Log.d("InitializationFailure", youTubeInitializationResult.toString())
                }
            })
        apiService.search(youtubeVideos[position].id)
            .enqueue(object : Callback<YoutubeVideoResponse> {
                override fun onFailure(
                    call: Call<YoutubeVideoResponse>,
                    t: Throwable
                ) {
                    Log.d("CallbackFailure", t.toString())
                }


                override fun onResponse(
                    call: Call<YoutubeVideoResponse>,
                    response: Response<YoutubeVideoResponse>
                ) {
                    holder.videoTitle.text = response.body()?.items?.first()?.snippet!!.title
                }
            })


        holder.playButton.setOnClickListener {
            val intent = YouTubeStandalonePlayer.createVideoIntent(
                ctx as Activity,
                BuildConfig.YOUTUBE_API_KEY,
                youtubeVideos[position].id,
                100, true, false
            )
            ctx.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return youtubeVideos.size
    }

}