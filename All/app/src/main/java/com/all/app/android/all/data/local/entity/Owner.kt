package com.all.app.android.all.data.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Owner (
        @PrimaryKey(autoGenerate = true)
        val id: Long? = null,
        @ColumnInfo(name = "repo_id") val repoId: String,
        val avatar: String
)