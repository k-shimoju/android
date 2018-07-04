package com.all.app.android.all.data.local.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
//(foreignKeys = [(android.arch.persistence.room.ForeignKey(
//        entity = Owner::class,
//        parentColumns = ["id"],
//        childColumns = ["repoId"],
//        onDelete = ForeignKey.CASCADE))])
data class Repo (
        @PrimaryKey(autoGenerate = true)
        val keyId: Long? = null,
        val id: String,
        val name: String
)