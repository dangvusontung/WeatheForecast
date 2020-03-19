package sontung.dangvu.weatherforecast

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sontung.dangvu.weatherforecast.di.*
import sontung.dangvu.weatherforecast.model.weather.WeatherDataDetail
import sontung.dangvu.weatherforecast.retrofit.ApiUtils
import sontung.dangvu.weatherforecast.retrofit.WeatherAPI
import sontung.dangvu.weatherforecast.ui.adapter.WeatherDailyAdapter
import sontung.dangvu.weatherforecast.ui.adapter.WeatherDataDetailAdapter
import sontung.dangvu.weatherforecast.utils.LocationUtils
import sontung.dangvu.weatherforecast.viewmodel.WeatherDataViewModel
import javax.inject.Inject
import kotlin.math.roundToInt

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var weatherAPI: WeatherAPI

    @Inject
    lateinit var weatherViewModel: WeatherDataViewModel

    private var location : Location? = null


    private lateinit var recyclerView: RecyclerView
    private lateinit var weatherAdapter: WeatherDataDetailAdapter

    private lateinit var dailyRecyclerView: RecyclerView
    private lateinit var dailyAdapter: WeatherDailyAdapter

    private lateinit var cityName: TextView
    private lateinit var weatherSummary: TextView
    private lateinit var currentWeatherIcon: ImageView
    private lateinit var currentWeatherTemperature: TextView
    private lateinit var currentApparentTemperature: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermission()
        }

        weatherAPI = ApiUtils.getWeatherService()
        location = LocationUtils.getLocation(this)

        val component = DaggerAppComponent
            .builder()
            .weatherModule(WeatherModule(this.applicationContext))
            .locationModule(LocationModule((this)))
            .dbModule(DbModule(weatherAPI, location))
            .viewModelModule(ViewModelModule(this))
            .build()

        component.inject(this)
        //weatherViewModel = component.provideWeatherDataViewModel()

        weatherViewModel.weatherDetail.observe(this, Observer<WeatherDataDetail>{
            Log.d(TAG, "changed")
            cityName.text = LocationUtils.getCityName(location!!, this)
            weatherSummary.text = it.summary
            currentWeatherTemperature.text = "${it.temperature.roundToInt()}℃"
            currentApparentTemperature.text = "Feel like: ${it.apparentTemperature.roundToInt()}℃"
            when (it.icon) {
                "clear-day" -> currentWeatherIcon.setImageDrawable(
                    this.resources.getDrawable(
                        R.drawable.ic_clear_day,
                        null
                    )
                )
                "clear-night" -> currentWeatherIcon.setImageDrawable(
                    this.resources.getDrawable(
                        R.drawable.ic_night_clear,
                        null
                    )
                )
                "rain" -> currentWeatherIcon.setImageDrawable(
                    this.resources.getDrawable(
                        R.drawable.ic_rain,
                        null
                    )
                )
                "snow" -> currentWeatherIcon.setImageDrawable(
                    this.resources.getDrawable(
                        R.drawable.ic_snow,
                        null
                    )
                )
                "sleet" -> currentWeatherIcon.setImageDrawable(
                    this.resources.getDrawable(
                        R.drawable.ic_sleet,
                        null
                    )
                )
                "wind" -> currentWeatherIcon.setImageDrawable(
                    this.resources.getDrawable(
                        R.drawable.ic_windy,
                        null
                    )
                )
                "fog" -> currentWeatherIcon.setImageDrawable(
                    this.resources.getDrawable(
                        R.drawable.ic_fog,
                        null
                    )
                )
                "cloudy" -> currentWeatherIcon.setImageDrawable(
                    this.resources.getDrawable(
                        R.drawable.ic_cloudy,
                        null
                    )
                )
                "partly-cloudy-day" -> currentWeatherIcon.setImageDrawable(
                    this.resources.getDrawable(
                        R.drawable.ic_partly_cloudy,
                        null
                    )
                )
                "partly-cloudy-night" -> currentWeatherIcon.setImageDrawable(
                    this.resources.getDrawable(
                        R.drawable.ic_night_partly_cloudy,
                        null
                    )
                )
            }
        })

        weatherViewModel.weatherResult.observe(this, Observer {
            weatherAdapter.updateWeatherDataList(it.hourly.hourlyWeathers)
            dailyAdapter.updateList(it.dailyWeatherData.dailyList)
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
        currentWeatherIcon = findViewById(R.id.current_weather_icon)
        weatherAdapter = WeatherDataDetailAdapter(ArrayList(), this)
        currentWeatherTemperature = findViewById(R.id.current_weather_temperature)
        currentApparentTemperature = findViewById(R.id.current_apparent_temperature)
        recyclerView.adapter = weatherAdapter

        dailyRecyclerView = findViewById(R.id.daily_recyclerView)
        dailyAdapter = WeatherDailyAdapter(ArrayList(), this)
        dailyRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        dailyRecyclerView.adapter = dailyAdapter
    }

    private fun loadData() {
        weatherViewModel.getData()
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
    }


}
