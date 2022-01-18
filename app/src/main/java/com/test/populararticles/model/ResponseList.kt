package com.test.populararticles.model

import com.example.coroutineretrofitdemo.model.Articles
import com.google.gson.annotations.SerializedName

data class ResponseList(@SerializedName("results")
                        val results: ArrayList<Articles>)
