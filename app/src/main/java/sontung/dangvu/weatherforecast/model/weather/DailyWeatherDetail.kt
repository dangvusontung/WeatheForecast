package sontung.dangvu.weatherforecast.model.weather

import com.google.gson.annotations.SerializedName

class DailyWeatherDetail(
    @SerializedName("time")
    val dailyDetailTime: Long,
    @SerializedName("summary")
    val dailyDetailSummary: String,
    @SerializedName("icon")
    val dailyDetailIcon: String,
    @SerializedName("temperatureLow")
    val temperatureLow: Double,
    @SerializedName("temperatureHigh")
    val temperatureHigh: Double
) {
}