package com.all.app.android.all.di

import com.all.app.android.all.ui.main.navi.NaviFragment
import com.all.app.android.all.ui.main.navi.result.ResultFragment
import com.all.app.android.all.ui.main.repos.ReposFragment
import com.all.app.android.all.ui.main.repos_db.ReposDbFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class UiModule {

    @ContributesAndroidInjector
    internal abstract fun contributeReposFragmentInjector(): ReposFragment

    @ContributesAndroidInjector
    internal abstract fun contributeResultFragmentInjector(): ResultFragment

    @ContributesAndroidInjector
    internal abstract fun contributeNaviFragmentInjector(): NaviFragment

    @ContributesAndroidInjector
    internal abstract fun contributeReposDbFragmentInjector(): ReposDbFragment
}