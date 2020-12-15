package com.viper.githubapisearch

import retrofit2.Call
import retrofit2.http.GET

interface GitHubSearchApi {
    @GET("/users/pmessina/repos")
    fun listArticles(): Call<GitHubApiRequest>
}