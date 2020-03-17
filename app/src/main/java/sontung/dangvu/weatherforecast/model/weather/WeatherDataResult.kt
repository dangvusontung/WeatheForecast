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
    val hourly : HourlyWeatherData

) {
    override fun toString(): String {
        return "WeatherDataResult(latitude='$latitude', \nlongitude='$longitude', \ntimezone='$timezone', \ncurrently=$currently, \nhourly=$hourly)\n"
    }
}