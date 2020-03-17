package sontung.dangvu.weatherforecast.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sontung.dangvu.weatherforecast.R
import sontung.dangvu.weatherforecast.ui.viewholder.WeatherDataDetailViewHolder
import sontung.dangvu.weatherforecast.model.weather.WeatherDataDetail

class WeatherDataDetailAdapter(private var weatherDataList : List<WeatherDataDetail>) :
    RecyclerView.Adapter<WeatherDataDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDataDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_data_item, parent, false)
        return WeatherDataDetailViewHolder(
            view
        )
    }

    override fun getItemCount(): Int = weatherDataList.size

    override fun onBindViewHolder(holder: WeatherDataDetailViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    fun updateWeatherDataList(list : List<WeatherDataDetail>) {
        weatherDataList = list
    }
}