package com.rasoulian.learndiwithcoin

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query
import java.time.LocalDate

public interface NasaApiService {

    @GET("planetary/apod?api_key=U2OJNnKBifCcRjuTvOmVmlg0HTI6UsUFp9iwGdsy")
    fun listRepos(@Query("start_date") startDate: LocalDate): Call<List<NasaMediaItem>>
}