package com.example.dsm_camp.connecter

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Part

interface API {
    @POST
    fun post(
        @Part("name") name: RequestBody,
        @Part("exp") exp: RequestBody,
        @Part("level") level: RequestBody
    ): Call<Unit>
}