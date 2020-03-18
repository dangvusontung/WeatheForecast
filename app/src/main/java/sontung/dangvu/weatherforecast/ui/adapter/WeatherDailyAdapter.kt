package sontung.dangvu.weatherforecast.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sontung.dangvu.weatherforecast.R
import sontung.dangvu.weatherforecast.model.weather.DailyWeatherDetail
import sontung.dangvu.weatherforecast.ui.viewholder.WeatherDailyViewHolder
import sontung.dangvu.weatherforecast.utils.NumberUtils
import kotlin.math.roundToInt

private const val TAG = "WeatherDailyAdapter"

class WeatherDailyAdapter(
    var dailyList: List<DailyWeatherDetail>,
    private val context: Context
) : RecyclerView.Adapter<WeatherDailyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDailyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.daily_weather_list_item, parent, false)
        return WeatherDailyViewHolder(view)
    }

    override fun getItemCount(): Int = dailyList.size

    override fun onBindViewHolder(holder: WeatherDailyViewHolder, position: Int) {
        val weatherDailyWeatherData = dailyList[position]
        holder.dailyDay.text =
            NumberUtils.convertTimeToDate(weatherDailyWeatherData.dailyDetailTime)
        holder.dailyHighTemp.text = weatherDailyWeatherData.temperatureHigh.roundToInt().toString()
        holder.dailyLowTemp.text = weatherDailyWeatherData.temperatureLow.roundToInt().toString()
        when (weatherDailyWeatherData.dailyDetailIcon) {
            "clear-day" -> holder.dailyIcon.setImageDrawable(context.getDrawable(R.drawable.ic_clear_day))
            "clear-night" -> holder.dailyIcon.setImageDrawable(context.getDrawable(R.drawable.ic_night_clear))
            "rain" -> holder.dailyIcon.setImageDrawable(context.getDrawable(R.drawable.ic_rain))
            "snow" -> holder.dailyIcon.setImageDrawable(context.getDrawable(R.drawable.ic_snow))
            "sleet" -> holder.dailyIcon.setImageDrawable(context.getDrawable(R.drawable.ic_sleet))
            "wind" -> holder.dailyIcon.setImageDrawable(context.getDrawable(R.drawable.ic_windy))
            "fog" -> holder.dailyIcon.setImageDrawable(context.getDrawable(R.drawable.ic_fog))
            "cloudy" -> holder.dailyIcon.setImageDrawable(context.getDrawable(R.drawable.ic_cloudy))
            "partly-cloudy-day" -> holder.dailyIcon.setImageDrawable(context.getDrawable(R.drawable.ic_partly_cloudy))
            "partly-cloudy-night" -> holder.dailyIcon.setImageDrawable(context.getDrawable(R.drawable.ic_night_partly_cloudy))
        }
    }

    fun updateList(list: List<DailyWeatherDetail>) {
        Log.d(TAG, "updateList")
        dailyList = list
        notifyDataSetChanged()
        Log.d(TAG, "${list.size}")
    }


}