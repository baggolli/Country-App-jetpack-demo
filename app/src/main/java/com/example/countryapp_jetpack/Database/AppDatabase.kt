package com.example.countryapp_jetpack.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.countryapp_jetpack.dao.CountryDao
import com.example.countryapp_jetpack.entity.CountryEntity

@Database(entities = [(CountryEntity::class)], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun countryDao() : CountryDao
}


