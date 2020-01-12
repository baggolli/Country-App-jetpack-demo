package com.example.countryapp_jetpack.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.countryapp_jetpack.Database.RoomDBApplication
import com.example.countryapp_jetpack.entity.CountryEntity
import com.example.countryapp_jetpack.model.Country
import com.example.countryapp_jetpack.retrofit.ApiClient.getClient
import com.example.countryapp_jetpack.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryRepository {
    private val countryDao = RoomDBApplication.database?.countryDao()
    private val isLoading = MutableLiveData<Boolean>()

    fun getIsLoading(): MutableLiveData<Boolean> {
        return isLoading
    }

    fun fetchCountryList(): LiveData<List<CountryEntity>>? {
        isLoading.postValue(true)
        val apiService = getClient()?.create(ApiInterface::class.java)
        apiService?.getAllCountries()?.enqueue(object : Callback<MutableList<Country>> {
            override fun onResponse(call: Call<MutableList<Country>>?, response: Response<MutableList<Country>>?) {
                isLoading.postValue(false)
                val countryList = response?.body()?.map { CountryEntity(name = it.name, capital = it.capital, population = it.population, flag = it.flag) }
                Thread(Runnable { countryDao?.upsertCountry(countryList) }).start()
            }
            override fun onFailure(call: Call<MutableList<Country>>?, throwable: Throwable?) {
                isLoading.postValue(false)
            }
        })
        return countryDao?.getAllCountries()
    }
}