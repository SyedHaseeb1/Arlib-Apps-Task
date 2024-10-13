package com.hsb.task.data.remote

import com.hsb.task.data.model.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("raw/W4FMf7Wm")
    suspend fun fetchDrugs(): ApiResponse
}

