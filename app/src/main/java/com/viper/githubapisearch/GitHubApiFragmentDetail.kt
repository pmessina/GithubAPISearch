package com.viper.githubapisearch

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_git_hub_api_detail.*


class GitHubApiFragmentDetail : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_git_hub_api_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvDescription.text = this.arguments?.getString("tvDescription")
        tvCreateDate.text = this.arguments?.getString("tvCreateDate")
        tvLastPushDate.text = this.arguments?.getString("tvLastPushDate")
        tvLanguage.text = this.arguments?.getString("tvLanguage")
        tvAvatarURL.text = this.arguments?.getString("tvAvatarURL")

        val htmlURL = this.arguments?.getString("btnOpenProject")

        btnOpenProject.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(htmlURL))
            startActivity(browserIntent)
        }
    }

}