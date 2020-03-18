package sontung.dangvu.weatherforecast.ui.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sontung.dangvu.weatherforecast.R

class WeatherDailyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val dailyDay = itemView.findViewById<TextView>(R.id.daily_day)
    val dailyIcon = itemView.findViewById<ImageView>(R.id.daily_icon)
    val dailyLowTemp = itemView.findViewById<TextView>(R.id.daily_low_temperature)
    val dailyHighTemp = itemView.findViewById<TextView>(R.id.daily_high_temperature)
}