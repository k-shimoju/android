package com.all.app.android.all.ui.main.repos_db

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.all.app.android.all.data.local.entity.RepoOwner
import com.all.app.android.all.data.repository.GithubRepository
import com.common.ext.isNotEmptyAndNull
import com.common.ext.switchMap
import com.common.util.AbsentLiveData
import javax.inject.Inject

class ReposDbViewModel @Inject constructor(repository: GithubRepository): ViewModel() {

    val userName = MutableLiveData<String>()
    val repoList: LiveData<List<RepoOwner>>

    init {
        repoList = userName.switchMap {
            if (isNotEmptyAndNull(userName))
                repository.findRepoOwner(it)
            else
                AbsentLiveData.create()
        }
    }
}