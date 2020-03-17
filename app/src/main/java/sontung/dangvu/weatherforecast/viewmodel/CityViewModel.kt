package sontung.dangvu.weatherforecast.viewmodel

import android.app.Application
import android.location.Location
import androidx.lifecycle.AndroidViewModel
import sontung.dangvu.weatherforecast.database.AppDatabase
import sontung.dangvu.weatherforecast.repository.CityRepository

class CityViewModel(application: Application) : AndroidViewModel(application) {

    val database = AppDatabase.getInstance(application)
    val cityDao = database.cityDao()

    val cityRepository = CityRepository(application, cityDao)

    fun getLocation() : Location? {
        return cityRepository.getCoordinates(getApplication())
    }

}