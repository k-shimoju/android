package com.all.app.android.all.data.local.dao

import android.arch.persistence.room.*
import com.all.app.android.all.data.local.entity.Owner

@Dao
interface OwnerDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(repo: Owner)

    @Update
    fun update(repo: Owner)

    @Delete
    fun delete(repo: Owner)

    @Query("SELECT * FROM Owner")
    fun findAll(): List<Owner>
}