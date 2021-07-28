package com.news.presentation.models.news

import android.os.Parcelable
import com.news.presentation.models.PresentationModel
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat

@Parcelize
data class ArticlePresentation(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: SourcePresentation?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
) : PresentationModel, Parcelable {

    fun getFormattedDate(): String? {
        return try {
            val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .parse(publishedAt)

            SimpleDateFormat("yy/mm/dd hh:mm")
                .format(date)


        } catch (e: Exception) {
            e.printStackTrace()
            publishedAt
        }

    }
}