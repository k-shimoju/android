package com.all.app.android.all.data.repository

import com.all.app.android.all.data.local.Database
import com.all.app.android.all.data.local.entity.Owner
import com.all.app.android.all.data.network.api.GithubService
import com.all.app.android.all.data.network.api.model.Repo
import javax.inject.Inject
import kotlin.concurrent.thread

class GithubRepository @Inject constructor(val githubService: GithubService, val database: Database) {

    fun listRepos(user: String) = githubService.listRepos(user)

    fun findRepoOwner(id: String) = database.repoDao().findRepoOwner("%${id}%")

    fun saveRepo(repos: List<Repo>) {

        thread {
            repos.forEach {
                database.repoDao().insert(com.all.app.android.all.data.local.entity.Repo(id = it.owner.login, name = it.name))
                database.ownerDao().insert(Owner(repoId = it.owner.login, avatar = it.owner.avatar))
            }
        }
    }
}