package com.viper.githubapisearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class GitHubViewModel(private val gitHubSearchRepository: GitHubSearchRepository) : ViewModel() {
    fun getRepository(): LiveData<GitHubApiRequest> {
        return gitHubSearchRepository.getGitHubSearchResults()
    }
}