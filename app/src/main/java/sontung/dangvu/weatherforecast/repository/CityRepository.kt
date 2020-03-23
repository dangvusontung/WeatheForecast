package sontung.dangvu.weatherforecast.repository

import android.content.Context
import android.location.Location
import androidx.lifecycle.MutableLiveData
import sontung.dangvu.weatherforecast.database.dao.CityDao
import sontung.dangvu.weatherforecast.model.city.City
import sontung.dangvu.weatherforecast.utils.LocationUtils

class CityRepository(private val context: Context, private val cityDao: CityDao) {

    val cites = MutableLiveData<List<City>>()

    suspend fun insertCity(city: City){
        cityDao.insertCity(city)
    }

    suspend fun deleteCity(city: City) {
        cityDao.deleteCity(city)
    }

    fun getAllCities() = cityDao.getAllCities()

    fun getCityName(latitude : Double, longitude : Double) : String {
        return LocationUtils.getCityName(latitude, longitude, context)
    }


}