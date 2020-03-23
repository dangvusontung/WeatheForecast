package sontung.dangvu.weatherforecast.di

import android.content.Context
import android.location.Location
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import sontung.dangvu.weatherforecast.MainActivity
import sontung.dangvu.weatherforecast.repository.WeatherRepository
import sontung.dangvu.weatherforecast.viewmodel.WeatherDataViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [DbModule::class, WeatherModule::class, ViewModelModule::class])
interface AppComponent {
    fun provideCompositeDisposable() : CompositeDisposable
    fun provideApplication(): Context
    fun provideRepository(): WeatherRepository
    fun provideWeatherDataViewModel(): WeatherDataViewModel
    fun inject(mainActivity: MainActivity)
}