package sontung.dangvu.weatherforecast.di

import android.location.Location
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import sontung.dangvu.weatherforecast.repository.WeatherRepository
import sontung.dangvu.weatherforecast.retrofit.WeatherAPI
import javax.inject.Singleton

@Module
class DbModule(
    private val weatherAPI: WeatherAPI,
    private val compositeDisposable: CompositeDisposable,
    private val location: Location?
) {
    @Singleton
    @Provides
    fun provideWeatherRepository(
    ): WeatherRepository {
        return WeatherRepository(weatherAPI, compositeDisposable, location)
    }
}