package com.example.coroutineretrofitdemo.retrofit

import com.example.coroutineretrofitdemo.model.Articles
import com.test.populararticles.model.ResponseList
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("mostviewed/all-sections/7.json?api-key=68bdgi77eHGpVPQwdqZ9NCx6jZyFoByD")
    suspend fun getArticles(): Response<ResponseList>
}

