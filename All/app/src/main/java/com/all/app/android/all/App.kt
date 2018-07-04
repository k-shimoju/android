package com.all.app.android.all

import com.all.app.android.all.di.DaggerAppComponent
import com.all.app.android.all.di.DatabaseModule
import dagger.android.support.DaggerApplication

class App: DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder()
            .application(this)
            .database(DatabaseModule())
            .build()
}