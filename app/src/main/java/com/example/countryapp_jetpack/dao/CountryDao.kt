package com.example.countryapp_jetpack.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.countryapp_jetpack.entity.CountryEntity

@Dao
abstract class CountryDao {
    @Query("SELECT * FROM Countries ORDER BY name ASC")
    abstract fun getAllCountries(): LiveData<List<CountryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAllCountries(countryList: List<CountryEntity>?)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun updateAllCountries(countryList: List<CountryEntity>?)

    @Transaction
    open fun upsertCountry(entities: List<CountryEntity>?) {
        insertAllCountries(entities)
        updateAllCountries(entities)
    }
}