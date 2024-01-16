package com.example.arquitectura.login.data.network

import com.example.arquitectura.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {

    @GET("/v3/e7d47777-ce8a-4575-ae73-beaf25b8aaaf")

    suspend fun doLogin(): Response<LoginResponse>

}