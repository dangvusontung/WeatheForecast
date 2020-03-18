package sontung.dangvu.weatherforecast.retrofit

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import sontung.dangvu.weatherforecast.model.weather.WeatherDataResult

private const val API_KEY = "8a82e5e36287b864d19a71f08b022e27"

interface WeatherAPI {
    @GET ("$API_KEY/{coordinates}")
    fun getWeatherData(
        @Path("coordinates") coordinates: String,
        @Query("lang") language: String
    ): Single<WeatherDataResult>

}