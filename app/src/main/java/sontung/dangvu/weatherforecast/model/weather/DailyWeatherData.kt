package sontung.dangvu.weatherforecast.model.weather

import com.google.gson.annotations.SerializedName

class DailyWeatherData(
    @SerializedName("summary")
    val daiySummary: String,
    @SerializedName("icon")
    val dailyIcon: String,
    @SerializedName("data")
    val dailyList: List<DailyWeatherDetail>
) {
    override fun toString(): String {
        return "DailyWeatherData(daiySummary='$daiySummary', dailyIcon='$dailyIcon', dailyList=$dailyList)"
    }
}