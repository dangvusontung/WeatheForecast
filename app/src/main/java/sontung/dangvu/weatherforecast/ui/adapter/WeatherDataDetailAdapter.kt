package sontung.dangvu.weatherforecast.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sontung.dangvu.weatherforecast.R
import sontung.dangvu.weatherforecast.model.weather.WeatherDataDetail
import sontung.dangvu.weatherforecast.ui.viewholder.WeatherDataDetailViewHolder
import sontung.dangvu.weatherforecast.utils.NumberUtils
import java.text.DecimalFormat

class WeatherDataDetailAdapter(
    private var weatherDataList: List<WeatherDataDetail>,
    private val context: Context
) :
    RecyclerView.Adapter<WeatherDataDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDataDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_data_item, parent, false)
        return WeatherDataDetailViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = weatherDataList.size

    override fun onBindViewHolder(holder: WeatherDataDetailViewHolder, position: Int) {
        val weatherDataDetail = weatherDataList[position]
        val dec = DecimalFormat("#")
        holder.date.text = NumberUtils.convertTimeToDate(weatherDataDetail.time)
        holder.hour.text = NumberUtils.convertTimeToHour(weatherDataDetail.time)
        holder.summary.text = weatherDataDetail.summary
        holder.temperature.text = "${dec.format(weatherDataDetail.temperature)}℃"
        when (weatherDataDetail.icon) {
            "clear-day" -> holder.icon.setImageDrawable(context.getDrawable(R.drawable.ic_clear_day))
            "clear-night" -> holder.icon.setImageDrawable(context.getDrawable(R.drawable.ic_night_clear))
            "rain" -> holder.icon.setImageDrawable(context.getDrawable(R.drawable.ic_rain))
            "snow" -> holder.icon.setImageDrawable(context.getDrawable(R.drawable.ic_snow))
            "sleet" -> holder.icon.setImageDrawable(context.getDrawable(R.drawable.ic_sleet))
            "wind" -> holder.icon.setImageDrawable(context.getDrawable(R.drawable.ic_windy))
            "fog" -> holder.icon.setImageDrawable(context.getDrawable(R.drawable.ic_fog))
            "cloudy" -> holder.icon.setImageDrawable(context.getDrawable(R.drawable.ic_cloudy))
            "partly-cloudy-day" -> holder.icon.setImageDrawable(context.getDrawable(R.drawable.ic_partly_cloudy))
            "partly-cloudy-night" -> holder.icon.setImageDrawable(context.getDrawable(R.drawable.ic_night_partly_cloudy))
        }
    }

    fun updateWeatherDataList(list : List<WeatherDataDetail>) {
//        convertListFtoC(list)
        weatherDataList = list
        notifyDataSetChanged()
    }

    private fun convertListFtoC(list: List<WeatherDataDetail>) {
        for (element in list) {
            element.convertFtoC()
        }
    }
}