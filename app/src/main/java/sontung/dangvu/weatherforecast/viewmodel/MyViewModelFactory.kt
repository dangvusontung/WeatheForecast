package sontung.dangvu.weatherforecast.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sontung.dangvu.weatherforecast.repository.WeatherRepository

class MyViewModelFactory(private val repository: WeatherRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherDataViewModel(repository) as T
    }


}