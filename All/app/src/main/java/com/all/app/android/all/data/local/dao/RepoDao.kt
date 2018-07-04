package com.all.app.android.all.data.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.all.app.android.all.data.local.entity.Repo
import com.all.app.android.all.data.local.entity.RepoOwner

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(repo: Repo)

    @Update
    fun update(repo: Repo)

    @Delete
    fun delete(repo: Repo)

    @Query("SELECT * FROM Repo")
    fun findAll(): List<Repo>

    @Query("SELECT Repo.id, Repo.name, Owner.avatar FROM Repo LEFT JOIN Owner ON Repo.id = Owner.repo_id WHERE Repo.id LIKE :id")
    fun findRepoOwner(id: String): LiveData<List<RepoOwner>>
}