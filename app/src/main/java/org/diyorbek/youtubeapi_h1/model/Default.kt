package org.diyorbek.youtubeapi_h1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Default(
    val height: Int,
    val url: String,
    val width: Int
): Parcelable