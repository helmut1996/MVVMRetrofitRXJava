package com.example.mvvmrestapi.data.api

import com.example.mvvmrestapi.model.Post
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET


interface PostApi {
    @GET("posts")
    fun getPosts():Single<List<Post>>
}