package com.all.app.android.all.data.network.api

import com.all.app.android.all.data.network.api.model.Repo
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubService {

    @GET("/users/{user}/repos")
    fun listRepos(@Path("user") user: String): Flowable<List<Repo>>
}