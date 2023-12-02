package com.aldair.laboratorio14

import retrofit2.http.GET
import retrofit2.http.Query

interface CovidService {
    @GET("us/daily.json")
    suspend fun getCovidDataForDate(@Query("date") date: Int): List<CovidResponse>
}