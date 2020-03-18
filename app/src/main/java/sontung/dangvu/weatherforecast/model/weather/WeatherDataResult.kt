package sontung.dangvu.weatherforecast.model.weather

import com.google.gson.annotations.SerializedName

class WeatherDataResult(
    @SerializedName("latitude")
    val latitude : String,
    @SerializedName("longitude")
    val longitude : String,
    @SerializedName("timezone")
    val timezone : String,
    @SerializedName("currently")
    val currently : WeatherDataDetail,
    @SerializedName("hourly")
    val hourly: HourlyWeatherData,
    @SerializedName("daily")
    val dailyWeatherData: DailyWeatherData

) {

    override fun toString(): String {
        return "WeatherDataResult(latitude='$latitude', longitude='$longitude', timezone='$timezone', currently=$currently, hourly=$hourly, dailyWeatherData=$dailyWeatherData)"
    }
}