package com.example.lab6.data

data class YoutubeVideo(val id: String) {
    companion object {
        fun initFirstPlaylist(): List<YoutubeVideo> {
            val videos = arrayListOf<YoutubeVideo>()
            videos.add(YoutubeVideo("3kSdNmkcmTE"))
            videos.add(YoutubeVideo("YB8IVbvdoW0"))
            videos.add(YoutubeVideo("_mgfpB5XXEs"))

            return videos
        }

        fun initSecondPlaylist(): List<YoutubeVideo> {
            val videos = arrayListOf<YoutubeVideo>()
            videos.add(YoutubeVideo("3kSdNmkcmTE"))
            videos.add(YoutubeVideo("YB8IVbvdoW0"))
            videos.add(YoutubeVideo("_mgfpB5XXEs"))

            return videos
        }

        fun initThirdPlaylist(): List<YoutubeVideo> {
            val videos = arrayListOf<YoutubeVideo>()
            videos.add(YoutubeVideo("3kSdNmkcmTE"))
            videos.add(YoutubeVideo("YB8IVbvdoW0"))
            videos.add(YoutubeVideo("_mgfpB5XXEs"))

            return videos
        }
    }
}