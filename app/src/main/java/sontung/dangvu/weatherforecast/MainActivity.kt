package sontung.dangvu.weatherforecast

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sontung.dangvu.weatherforecast.model.weather.WeatherDataDetail
import sontung.dangvu.weatherforecast.retrofit.ApiUtils
import sontung.dangvu.weatherforecast.retrofit.WeatherAPI
import sontung.dangvu.weatherforecast.ui.adapter.WeatherDataDetailAdapter
import sontung.dangvu.weatherforecast.utils.LocationUtils
import sontung.dangvu.weatherforecast.viewmodel.WeatherDataViewModel

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var weatherAPI: WeatherAPI

    private val weatherViewModel : WeatherDataViewModel by viewModels()
    private var location : Location? = null


    private lateinit var recyclerView: RecyclerView
    private lateinit var weatherAdapter: WeatherDataDetailAdapter

    private lateinit var cityName: TextView
    private lateinit var weatherSummary: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermission()
        }

        location = weatherViewModel.location
        weatherAPI = ApiUtils.getWeatherService()
        weatherViewModel.weatherDetail.observe(this, Observer<WeatherDataDetail>{
            Log.d(TAG, "changed")
            cityName.text = LocationUtils.getCityName(weatherViewModel.location!!, this)
            weatherSummary.text = it.summary

        })

        weatherViewModel.weatherResult.observe(this, Observer {
            weatherAdapter.updateWeatherDataList(it.hourly.hourlyWeathers)
        })

        initView()
        loadData()

    }

    private fun initView() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        weatherSummary = findViewById(R.id.weather_summary_textview)
        cityName = findViewById(R.id.weather_location_textView)
        weatherAdapter = WeatherDataDetailAdapter(ArrayList())
        recyclerView.adapter = weatherAdapter
    }


    private fun loadData() {
        weatherViewModel.getData()
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
    }


}
