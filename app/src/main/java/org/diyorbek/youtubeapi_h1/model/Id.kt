package org.diyorbek.youtubeapi_h1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Id(
    val kind: String,
    val videoId: String
): Parcelable