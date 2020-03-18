package sontung.dangvu.weatherforecast.repository

import android.location.Location
import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import sontung.dangvu.weatherforecast.model.weather.WeatherDataDetail
import sontung.dangvu.weatherforecast.model.weather.WeatherDataResult
import sontung.dangvu.weatherforecast.retrofit.WeatherAPI
import javax.inject.Inject

private const val TAG = "WeatherRepository"
class WeatherRepository @Inject constructor(
    private val weatherAPI: WeatherAPI,
    private val disposable : CompositeDisposable,
    var location: Location?
) {

    val weatherDataDetail = MutableLiveData<WeatherDataDetail>()
    val weatherDataResult = MutableLiveData<WeatherDataResult>()

    fun getDataFromApi() {
        Log.d(TAG, "getDataFromApi")
        val latitude = location!!.latitude
        val longitude = location!!.longitude
        val queryCoordinate = "$latitude,$longitude"
        disposable.add(
            weatherAPI.getWeatherData(queryCoordinate, "vi", "si")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<WeatherDataResult>(){
                    override fun onSuccess(t: WeatherDataResult) {
                        Log.d(TAG, "Success")
                        Log.d(TAG, "$t")
//                        t.currently.convertFtoC()
                        weatherDataDetail.value = t.currently
                        weatherDataResult.value = t
                    }

                    override fun onError(e: Throwable) {
                        Log.d(TAG, "Error")
                        e.printStackTrace()
                    }

                })
        )
    }

}