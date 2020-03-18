package sontung.dangvu.weatherforecast.ui.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sontung.dangvu.weatherforecast.R

class WeatherDataDetailViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val date: TextView = itemView.findViewById(R.id.day)
    val hour: TextView = itemView.findViewById(R.id.hour)
    val icon: ImageView = itemView.findViewById(R.id.icon)
    val summary: TextView = itemView.findViewById(R.id.summary)
    val temperature: TextView = itemView.findViewById(R.id.temperature)
}