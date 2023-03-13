package org.diyorbek.youtubeapi_h1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val etag: String,
    val id: Id,
    val kind: String,
    val snippet: Snippet
): Parcelable