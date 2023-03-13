package org.diyorbek.youtubeapi_h1.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import org.diyorbek.youtubeapi_h1.model.Item
import org.diyorbek.youtubeapi_h1.model.PageInfo

@Parcelize
data class YoutubeModel(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo,
    val regionCode: String
) : Parcelable