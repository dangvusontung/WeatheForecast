package sontung.dangvu.weatherforecast

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer

import sontung.dangvu.weatherforecast.model.weather.WeatherDataDetail
import sontung.dangvu.weatherforecast.retrofit.ApiUtils
import sontung.dangvu.weatherforecast.retrofit.WeatherAPI
import sontung.dangvu.weatherforecast.utils.LocationUtils
import sontung.dangvu.weatherforecast.viewmodel.WeatherDataViewModel

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var weatherAPI: WeatherAPI

    private val weatherViewModel : WeatherDataViewModel by viewModels()
    private var location : Location? = null

    //For testing, remove later
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermission()
        }

        textView = findViewById(R.id.textview)
        location = weatherViewModel.location
        weatherAPI = ApiUtils.getWeatherService()
        weatherViewModel.weatherDetail.observe(this, Observer<WeatherDataDetail>{
            Log.d(TAG, "changed")
            textView.text = LocationUtils.getCityName(location!!.latitude, location!!.longitude, this) + ", ${it.temperature}, ${it.apparentTemperature}"
        })

        loadData()

    }



    private fun loadData() {
        weatherViewModel.getData()
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
    }


}
