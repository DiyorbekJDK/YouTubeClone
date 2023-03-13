package org.diyorbek.youtubeapi_h1.network

import org.diyorbek.youtubeapi_h1.model.YoutubeModel
import retrofit2.*
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeService {

    @GET("search")
    fun getAllData(
        @Query("key") key: String = "AIzaSyAZ3ALbe4vzKb2UQgb1gnlEyATyKdgAC0Y",
        @Query("channelId") channelId: String = "UCoNrZLYzYTLow9OnyANLqrQ",
        @Query("order") order: String = "date",
        @Query("maxResults") maxResults: String = "1800",
        @Query("part") part: String = "snippet,id"

    ): Call<YoutubeModel>
}