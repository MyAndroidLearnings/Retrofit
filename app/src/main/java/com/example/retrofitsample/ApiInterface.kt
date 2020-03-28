package com.example.retrofitsample

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("marvel")
    fun getValues(): Call<List<ModelClass>>
}
