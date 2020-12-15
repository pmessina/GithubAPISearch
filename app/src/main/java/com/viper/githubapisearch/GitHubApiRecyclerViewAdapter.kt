package com.viper.githubapisearch

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GitHubApiRecyclerViewAdapter(private val context: Context) :
    RecyclerView.Adapter<GitHubApiViewHolder>() {

    var gitHubApiRequest: GitHubApiRequest = GitHubApiRequest()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubApiViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_github_repo_name, parent, false)
        return GitHubApiViewHolder(context, view)
    }

    override fun onBindViewHolder(holder: GitHubApiViewHolder, position: Int) {
        val gitHubApi = gitHubApiRequest[position]
        holder.tvGitHubRepoName.tag = gitHubApi
        holder.tvGitHubRepoName.text = gitHubApi.name

    }

    override fun getItemCount(): Int {
        return gitHubApiRequest.size
    }
}

