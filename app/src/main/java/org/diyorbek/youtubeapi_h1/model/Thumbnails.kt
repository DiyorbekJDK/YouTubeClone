package org.diyorbek.youtubeapi_h1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.diyorbek.youtubeapi_h1.model.Default

@Parcelize
data class Thumbnails(
    val default: Default
): Parcelable