package com.asya.weatherapp.ui.favoritesWeather

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_list")
class FavoriteCityEntity (
    @PrimaryKey
    @ColumnInfo(name = "cityName")
    var cityName: String = ""
)