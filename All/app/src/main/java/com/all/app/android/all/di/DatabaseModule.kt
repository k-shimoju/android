package com.all.app.android.all.di

import android.arch.persistence.room.Room
import com.all.app.android.all.App
import com.all.app.android.all.data.local.Database
import com.all.app.android.all.data.local.dao.OwnerDao
import com.all.app.android.all.data.local.dao.RepoDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: App): Database = Room.databaseBuilder(app, Database::class.java,
            "all_sample.db").build()

    @Provides
    @Singleton
    fun provideRepoDao(db: Database): RepoDao = db.repoDao()

    @Provides
    @Singleton
    fun provideOwnerDao(db: Database): OwnerDao = db.ownerDao()
}