package com.rasoulian.learndiwithcoin


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NasaMediaItem(
    val copyright: String?,
    val date: String,
    val explanation: String,
    val hdurl: String?,
    @Json(name = "media_type")
    val mediaType: NasaMediaType,
    @Json(name = "service_version")
    val serviceVersion: String,
    val title: String,
    val url: String
) {
    enum class NasaMediaType {
        @Json(name = "image")
        Image,
        @Json(name = "video")
        Video
    }
}