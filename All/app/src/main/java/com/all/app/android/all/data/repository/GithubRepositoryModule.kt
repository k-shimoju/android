package com.all.app.android.all.data.repository

import com.all.app.android.all.data.local.Database
import com.all.app.android.all.data.network.api.GithubService
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class GithubRepositoryModule @Inject constructor(val database: Database) {

    @Provides
    @Singleton
    fun provideGithubService(githubService: GithubService) = GithubRepository(githubService, database)
}