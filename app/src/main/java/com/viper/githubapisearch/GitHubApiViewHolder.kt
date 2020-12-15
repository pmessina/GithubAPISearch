package com.viper.githubapisearch

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


class GitHubApiViewHolder(private val context: Context, v: View) : RecyclerView.ViewHolder(v) {

    val tvGitHubRepoName = v.findViewById(R.id.github_repo_name) as TextView

    init {

        tvGitHubRepoName.setOnClickListener {
            Toast.makeText(v.context, "Textview selected", Toast.LENGTH_SHORT).show()

            val gitHubApiDetails = GitHubApiFragmentDetail()

            val gitHubApiRequest = v.tag as GitHubApiRequestItem

            val bundle = Bundle()
            bundle.apply {
                putString("tvDescription", gitHubApiRequest.description)
                putString("tvCreateDate", gitHubApiRequest.created_at)
                putString("tvLastPushDate", gitHubApiRequest.pushed_at)
                putString("tvLanguage", gitHubApiRequest.language)
                putString("tvAvatarURL", gitHubApiRequest.owner.avatar_url)
                putString("btnOpenProject", gitHubApiRequest.html_url)

            }
            gitHubApiDetails.arguments = bundle

            (v.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.results_view_github_search, gitHubApiDetails).commit()
        }
    }
}