package com.example.lab6.data

data class YoutubeVideo(val id: String) {
    companion object {
        fun initFirstPlaylist(): List<YoutubeVideo> {
            val videos = arrayListOf<YoutubeVideo>()
            videos.add(YoutubeVideo("3kSdNmkcmTE"))
            videos.add(YoutubeVideo("YB8IVbvdoW0"))
            videos.add(YoutubeVideo("_mgfpB5XXEs"))
            videos.add(YoutubeVideo("4w3cZjm0wa4"))
            videos.add(YoutubeVideo("UNeqgpoB8WI"))

            return videos
        }

        fun initSecondPlaylist(): List<YoutubeVideo> {
            val videos = arrayListOf<YoutubeVideo>()
            videos.add(YoutubeVideo("Z98hXV9GmzY"))
            videos.add(YoutubeVideo("K2dodTXARqc"))
            videos.add(YoutubeVideo("cD7NPxuuXYY"))
            videos.add(YoutubeVideo("JLLnhwtDoHw"))

            return videos
        }

        fun initThirdPlaylist(): List<YoutubeVideo> {
            val videos = arrayListOf<YoutubeVideo>()
            videos.add(YoutubeVideo("jbY9YlNVRLw"))
            videos.add(YoutubeVideo("Nf-fP2u9vjI"))
            videos.add(YoutubeVideo("qsKVL4FSHVI"))
            videos.add(YoutubeVideo("Ljtz7T8R_Hk"))

            return videos
        }
    }
}