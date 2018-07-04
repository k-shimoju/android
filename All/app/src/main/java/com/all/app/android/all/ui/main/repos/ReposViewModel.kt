package com.all.app.android.all.ui.main.repos

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.view.View
import com.all.app.android.all.data.network.api.model.Repo
import com.all.app.android.all.data.repository.GithubRepository
import com.common.ext.isNotEmptyAndNull
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ReposViewModel @Inject constructor(val repository: GithubRepository): ViewModel() {

    val userName = MutableLiveData<String>()
    val repoList = MutableLiveData<List<Repo>>()

    fun getRepoList(view: View) {

        if (isNotEmptyAndNull(userName.value)) {
            repository.listRepos(userName.value!!)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {repos ->
                        repoList.postValue(repos)
                        repository.saveRepo(repos)
                    }
        }
    }
}