package com.example.coroutineretrofitdemo.model

import com.google.gson.annotations.SerializedName

data class Articles(@SerializedName("title")
                   val title: String?,
                    @SerializedName("byline")
                   val byline: String?,
                    @SerializedName("published_date")
                   val published_date: String?
)