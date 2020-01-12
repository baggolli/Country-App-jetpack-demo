package com.example.countryapp_jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countryapp_jetpack.entity.CountryEntity
import com.example.countryapp_jetpack.repository.CountryRepository

class CountryViewModel : ViewModel() {
    private var countryViewModel: CountryRepository = CountryRepository()

    fun getIsLoading(): MutableLiveData<Boolean> {
        return countryViewModel.getIsLoading()
    }

    fun getAllCountryList(): LiveData<List<CountryEntity>>? {
        return countryViewModel.fetchCountryList()
    }
}