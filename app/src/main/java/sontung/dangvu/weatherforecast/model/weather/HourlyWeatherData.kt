package sontung.dangvu.weatherforecast.model.weather

import com.google.gson.annotations.SerializedName

class HourlyWeatherData (
    @SerializedName("summary")
    val summary : String,
    @SerializedName("icon")
    val icon : String,
    @SerializedName("data")
    val hourlyWeathers : List<WeatherDataDetail>
) {
    override fun toString(): String {
        return "HourlyWeatherData(summary='$summary', icon='$icon', hourlyWeathers=$hourlyWeathers)"
    }
}