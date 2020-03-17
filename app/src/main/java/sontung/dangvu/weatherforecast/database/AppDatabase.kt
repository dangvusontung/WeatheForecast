package sontung.dangvu.weatherforecast.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import sontung.dangvu.weatherforecast.database.dao.CityDao
import sontung.dangvu.weatherforecast.model.city.City
import sontung.dangvu.weatherforecast.model.weather.WeatherDataDetail

@Database(entities = [City::class, WeatherDataDetail::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cityDao() : CityDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_db"
                ).build()

                INSTANCE = instance
                return INSTANCE as AppDatabase

            }

        }

    }
}