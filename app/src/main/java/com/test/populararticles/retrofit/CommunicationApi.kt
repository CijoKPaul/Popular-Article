package com.example.coroutineretrofitdemo.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object CommunicationApi {
    val API_BASE_URL = "http://api.nytimes.com/svc/mostpopular/v2/"
    lateinit var client : OkHttpClient
    var apiService : ApiInterface? = null

    fun getService(): ApiInterface{
        apiService?.let {
            return it
        }?: kotlin.run {
            apiService = restAdapterGen(API_BASE_URL)
            return apiService!!
        }
    }

    fun restAdapterGen(baseURl : String): ApiInterface{
        val retrofit = Retrofit.Builder().baseUrl(baseURl)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiInterface::class.java)
        return retrofit
    }

}
