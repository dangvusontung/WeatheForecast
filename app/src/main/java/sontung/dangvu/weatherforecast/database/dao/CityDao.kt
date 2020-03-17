package sontung.dangvu.weatherforecast.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import sontung.dangvu.weatherforecast.model.city.City

@Dao
interface CityDao {

    @Insert
    suspend fun insertCity(city: City)

    @Delete
    suspend fun deleteCity(city: City)

    @Query("SELECT * FROM city_table")
    fun getAllCities() : LiveData<List<City>>

}