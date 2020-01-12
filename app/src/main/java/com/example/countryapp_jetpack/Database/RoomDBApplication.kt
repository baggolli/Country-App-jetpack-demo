package com.example.countryapp_jetpack.Database

import android.app.Application
import androidx.room.Room

class RoomDBApplication : Application() {
    companion object {
        var database: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "country_database")
            .fallbackToDestructiveMigration()
            .build()
    }
}