package com.viper.githubapisearch

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class GitHubApiApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@GitHubApiApplication)
            modules(gitHubModule)
        }
    }

    private val gitHubModule : Module = module {
        viewModel {
            GitHubViewModel(get())
        }
        single{GitHubSearchRepository()}
    }
}