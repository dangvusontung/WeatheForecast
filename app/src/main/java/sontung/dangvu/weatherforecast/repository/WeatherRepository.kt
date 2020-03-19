package sontung.dangvu.weatherforecast.repository

import android.location.Location
import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.Single
import sontung.dangvu.weatherforecast.model.weather.WeatherDataDetail
import sontung.dangvu.weatherforecast.model.weather.WeatherDataResult
import sontung.dangvu.weatherforecast.retrofit.WeatherAPI
import javax.inject.Inject

private const val TAG = "WeatherRepository"
class WeatherRepository @Inject constructor(
    private val weatherAPI: WeatherAPI,
    var location: Location?
) {
    val weatherDataDetail = MutableLiveData<WeatherDataDetail>()
    val weatherDataResult = MutableLiveData<WeatherDataResult>()

    fun getDataFromApi(): Single<WeatherDataResult> {
        Log.d(TAG, "getDataFromApi")
        val latitude = location!!.latitude
        val longitude = location!!.longitude
        val queryCoordinate = "$latitude,$longitude"
        val queryLanguage = "vi"
        val queryUnits = "si"
        return weatherAPI.getWeatherData(queryCoordinate, queryLanguage, queryUnits)
    }

    fun saveDataToDB() {

    }

}