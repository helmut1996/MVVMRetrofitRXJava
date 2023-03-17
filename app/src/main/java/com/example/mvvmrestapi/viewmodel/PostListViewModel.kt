package com.example.mvvmrestapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmrestapi.data.api.PostService
import com.example.mvvmrestapi.model.Post
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class PostListViewModel: ViewModel() {

    val posts = MutableLiveData<List<Post>>()

    private val postService:PostService = PostService()
    private val disposable:CompositeDisposable = CompositeDisposable()

    fun refresh(){
    fetchDataFromRemoteApi()
    }

    fun fetchDataFromRemoteApi(){
        disposable.add(
            postService.getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSingleObserver<List<Post>>(){
                    override fun onSuccess(postList: List<Post>) {
                        posts.value =postList
                    }

                    override fun onError(e: Throwable) {

                        e.printStackTrace()
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}