package sontung.dangvu.weatherforecast.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import sontung.dangvu.weatherforecast.di.DaggerAppComponent
import sontung.dangvu.weatherforecast.di.DaggerLocationComponent
import sontung.dangvu.weatherforecast.di.LocationModule
import sontung.dangvu.weatherforecast.di.WeatherModule
import sontung.dangvu.weatherforecast.repository.WeatherRepository
import sontung.dangvu.weatherforecast.retrofit.ApiUtils

class WeatherDataViewModel(application: Application) : AndroidViewModel(application) {

    val isDataLoading = MutableLiveData<Boolean>()
    val component = DaggerLocationComponent.builder().locationModule(LocationModule(application)).build()
    val disposable = DaggerAppComponent.builder().weatherModule(WeatherModule()).build().provideCompositeDisposable()
    val api = ApiUtils.getWeatherService()
    val location = component.provideLocation()
    val weatherRepository = WeatherRepository(api, disposable, null)

    val weatherDetail = weatherRepository.weatherDataDetail

    fun getData(){
        weatherRepository.location = location
        weatherRepository.getDataFromApi()
    }

}