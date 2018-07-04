package com.all.app.android.all.data.network.api.model

import com.squareup.moshi.Json

data class Owner (@Json(name = "avatar_url") val avatar: String, val login: String)