package com.news.presentation.models.news

import android.os.Parcelable
import com.news.presentation.models.PresentationModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SourcePresentation(
    val id: String?,
    val name: String?
) : PresentationModel, Parcelable