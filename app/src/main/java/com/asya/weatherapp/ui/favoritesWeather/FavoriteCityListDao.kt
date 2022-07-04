package com.asya.weatherapp.ui.favoritesWeather

import androidx.room.*

@Dao
interface FavoriteCityListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg entity: FavoriteCityEntity): LongArray
    // delete ve get all ekle
    @Delete
    fun delete(vararg entity: FavoriteCityEntity):  Integer
    @Query("SELECT * FROM city_list")
     fun getAllCity(): List<FavoriteCityEntity>
}
