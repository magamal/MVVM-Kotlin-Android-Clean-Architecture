package com.news.remote.models.news


import com.google.gson.annotations.SerializedName
import com.news.remote.models.RemoteModel

data class NewsResponseModel(
    @SerializedName("articles")
    val articles: List<ArticleModel>?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("totalResults")
    val totalResults: Int?
) : RemoteModel