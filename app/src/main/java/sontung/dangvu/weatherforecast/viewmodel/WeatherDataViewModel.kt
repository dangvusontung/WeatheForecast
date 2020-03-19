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
        weatherRepository.getDataFromApi()

        compositeDisposable.add(
            weatherRepository.getDataFromApi()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<WeatherDataResult>() {
                    override fun onSuccess(t: WeatherDataResult) {
                        Log.d(TAG, "Success")
                        Log.d(TAG, "$t")
                        weatherDetail.value = t.currently
                        weatherResult.value = t
                    }

                    override fun onError(e: Throwable) {
                        Log.d(TAG, "Error")
                        e.printStackTrace()
                    }

                })
        )

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}