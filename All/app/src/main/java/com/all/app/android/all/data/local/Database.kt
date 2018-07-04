package com.all.app.android.all.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.all.app.android.all.data.local.dao.OwnerDao
import com.all.app.android.all.data.local.dao.RepoDao
import com.all.app.android.all.data.local.entity.Owner
import com.all.app.android.all.data.local.entity.Repo

@Database(entities = [Owner::class, Repo::class], version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {

    abstract fun repoDao(): RepoDao
    abstract fun ownerDao(): OwnerDao
}