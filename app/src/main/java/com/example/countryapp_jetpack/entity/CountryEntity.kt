package com.example.countryapp_jetpack.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Countries")
data class CountryEntity(
    val name: String,
    val capital: String,
    val population: Int,
    val flag: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}