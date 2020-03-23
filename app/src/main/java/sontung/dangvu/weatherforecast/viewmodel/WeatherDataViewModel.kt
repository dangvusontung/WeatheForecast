package sontung.dangvu.weatherforecast.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import sontung.dangvu.weatherforecast.model.weather.WeatherDataResult
import sontung.dangvu.weatherforecast.repository.WeatherRepository
import javax.inject.Inject

class WeatherDataViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val TAG = "WeatherDataViewModel"

    companion object {
        private const val TAG = "WeatherDataViewModel"
    }

    private val compositeDisposable = CompositeDisposable()

    init {
        Log.d(TAG, "weatherRepo : $weatherRepository, disposable : $compositeDisposable")
    }

    val weatherDetail = weatherRepository.weatherDataDetail
    val weatherResult = weatherRepository.weatherDataResult

    fun getData(){
        compositeDisposable.add(
            weatherRepository.getDataFromApi()
        )

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}