package org.diyorbek.youtubeapi_h1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PageInfo(
    val resultsPerPage: Int,
    val totalResults: Int
): Parcelable