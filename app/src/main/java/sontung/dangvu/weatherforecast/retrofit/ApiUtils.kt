package sontung.dangvu.weatherforecast.retrofit

const val BASE_URL = "https://api.darksky.net/forecast/"
class ApiUtils {
    companion object {
        fun getWeatherService() : WeatherAPI {
            return RetrofitClient.getClient(BASE_URL).create(WeatherAPI::class.java)
        }
    }
}