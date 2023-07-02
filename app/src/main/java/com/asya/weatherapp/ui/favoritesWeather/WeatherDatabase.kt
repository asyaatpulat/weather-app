package com.asya.weatherapp.ui.favoritesWeather

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.asya.weatherapp.Configs

@Database(
    entities = [FavoriteCityEntity::class],
    version = 1
)

abstract class WeatherDatabase : RoomDatabase() {
    abstract fun favoriteCityListDao(): FavoriteCityListDao

    companion object {
        lateinit var instance: WeatherDatabase
        fun initDatabase(context: Context) {
            instance = Room.databaseBuilder(
                context,
                WeatherDatabase::class.java,
                Configs.Database.NAME
            ).fallbackToDestructiveMigration().build()
        }
    }
}
