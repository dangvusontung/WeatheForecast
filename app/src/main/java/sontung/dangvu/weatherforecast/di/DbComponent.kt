package sontung.dangvu.weatherforecast.di

import dagger.Component
import sontung.dangvu.weatherforecast.repository.WeatherRepository
import javax.inject.Singleton

@Singleton
@Component(modules = [DbModule::class])
interface DbComponent {
    fun provideWeatherRepository(): WeatherRepository
}