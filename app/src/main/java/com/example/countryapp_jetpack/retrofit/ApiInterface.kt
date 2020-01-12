package com.example.countryapp_jetpack.retrofit

import com.example.countryapp_jetpack.model.Country
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("all")
    fun getAllCountries() : Call<MutableList<Country>>
}