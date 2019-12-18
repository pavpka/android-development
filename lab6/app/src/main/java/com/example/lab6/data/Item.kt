package com.example.lab6.data

import com.google.gson.annotations.SerializedName

data class Item(@SerializedName("id") val id : String,
                @SerializedName("snippet") val snippet : Snippet)