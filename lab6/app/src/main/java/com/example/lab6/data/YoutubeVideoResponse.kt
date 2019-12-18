package com.example.lab6.data

import com.google.gson.annotations.SerializedName

data class YoutubeVideoResponse(@SerializedName("items") val items: List<Item>)