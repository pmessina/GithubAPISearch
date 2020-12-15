package com.viper.githubapisearch

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Component for consuming the web service
class GitHubSearchRepository {

    var newsApi: GitHubSearchApi
    lateinit var liveData: MutableLiveData<GitHubSearchApi>

    var retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://api.github.com").build()

    init {
        newsApi = retrofit.create(GitHubSearchApi::class.java)
    }

    fun getGitHubSearchResults(): MutableLiveData<GitHubApiRequest> {
        val newsData = MutableLiveData<GitHubApiRequest>()

        newsApi.listArticles().enqueue(object : Callback<GitHubApiRequest> {
            override fun onResponse(call: Call<GitHubApiRequest>, response: Response<GitHubApiRequest>) {
                newsData.value = response.body()
                Log.i("GitHubSearchApiRequest", response.body().toString())
            }

            override fun onFailure(call: Call<GitHubApiRequest>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return newsData
    }
}


