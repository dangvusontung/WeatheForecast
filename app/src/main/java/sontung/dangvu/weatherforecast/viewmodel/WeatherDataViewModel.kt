package sontung.dangvu.weatherforecast.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import sontung.dangvu.weatherforecast.di.*
import sontung.dangvu.weatherforecast.retrofit.ApiUtils

class WeatherDataViewModel(application: Application) : AndroidViewModel(application) {

    val isDataLoading = MutableLiveData<Boolean>()

    val component = DaggerLocationComponent.builder()
        .locationModule(LocationModule(application))
        .build()

    val disposable = DaggerAppComponent
        .builder().weatherModule(WeatherModule())
        .build().provideCompositeDisposable()

    val api = ApiUtils.getWeatherService()
    val location = component.provideLocation()

    val weatherRepository = DaggerDbComponent.builder()
        .dbModule(DbModule(api, disposable, location))
        .build()
        .provideWeatherRepository()

    val weatherDetail = weatherRepository.weatherDataDetail
    val weatherResult = weatherRepository.weatherDataResult

    fun getData(){
        weatherRepository.location = location
        weatherRepository.getDataFromApi()
    }

}