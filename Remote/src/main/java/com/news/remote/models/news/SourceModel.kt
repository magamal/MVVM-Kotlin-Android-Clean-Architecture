package com.news.remote.models.news


import com.google.gson.annotations.SerializedName
import com.news.remote.models.Model

data class SourceModel(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
) : Model