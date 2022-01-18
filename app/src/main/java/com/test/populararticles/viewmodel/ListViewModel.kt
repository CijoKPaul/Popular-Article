package com.example.coroutineretrofitdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutineretrofitdemo.model.Articles
import com.example.coroutineretrofitdemo.retrofit.CommunicationApi
import com.test.populararticles.model.ResponseList
import kotlinx.coroutines.*
import retrofit2.Response
import java.lang.Exception

class ListViewModel : ViewModel(){
    val artilcesLiveData = MutableLiveData<List<ResponseList>>()
    var job : Job? = null
    var response : Response<List<ResponseList>>? = null
    val articleLoadError = MutableLiveData<String>()

    fun fetchArticles(){
        response?.let {
            artilcesLiveData.value = it.body()
        }?: kotlin.run {
            job = CoroutineScope(Dispatchers.IO).launch {
                try {
                    response = CommunicationApi.getService().getArticles()
                }catch (e : Exception){
                    withContext(Dispatchers.Default){
                        articleLoadError.postValue(e.localizedMessage)
                    }
                }
                withContext(Dispatchers.Default){
                    response?.let {
                        if(it.isSuccessful){
                            artilcesLiveData.postValue(it.body())
                        }else{
                            articleLoadError.postValue(it.message())
                        }
                    }?: kotlin.run {
                        articleLoadError.postValue("Failed to fetch data. Please try again")
                    }
                }
            }
        }

    }
}