package com.news.presentation.models.news

import android.os.Parcelable
import com.news.presentation.models.PresentationModel
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*

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
        try {
            val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .parse(publishedAt)

            return SimpleDateFormat("yy/mm/dd hh:mm")
                .format(date)



        } catch (e: Exception) {
            e.printStackTrace()
            return publishedAt
        }

    }
}