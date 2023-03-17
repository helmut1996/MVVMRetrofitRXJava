package com.example.mvvmrestapi.data.api


import com.example.mvvmrestapi.model.Post
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PostService {
    private val BASE_URL = "https://jsonplaceholder.typicode.com"

    private  val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(PostApi::class.java)

    fun getPosts(): Single<List<Post>>{
        return api.getPosts()
    }
}