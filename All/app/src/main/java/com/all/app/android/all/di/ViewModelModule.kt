package com.all.app.android.all.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.all.app.android.all.ui.main.repos.ReposViewModel
import com.all.app.android.all.ui.main.repos_db.ReposDbViewModel
import com.common.di.ViewModelFactory
import com.common.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ReposViewModel::class)
    fun bindRepoViewModel(viewModel: ReposViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ReposDbViewModel::class)
    fun bindRepoDbViewModel(viewModel: ReposDbViewModel): ViewModel

//    @Binds
//    @IntoMap
//    @ViewModelKey(NaviViewModel::class)
//    fun bindNaviViewModel(viewModel: NaviViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(ResultViewModel::class)
//    fun bindResultViewModel(viewModel: ResultViewModel): ViewModel
}