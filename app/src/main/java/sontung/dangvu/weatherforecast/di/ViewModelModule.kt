package sontung.dangvu.weatherforecast.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import dagger.Module
import dagger.Provides
import sontung.dangvu.weatherforecast.repository.WeatherRepository
import sontung.dangvu.weatherforecast.viewmodel.MyViewModelFactory
import sontung.dangvu.weatherforecast.viewmodel.WeatherDataViewModel
import javax.inject.Singleton

@Module
class ViewModelModule(private val viewModelStoreOwner: ViewModelStoreOwner) {
    @Provides
    @Singleton
    fun provideWeatherDatViewModel(repository: WeatherRepository): WeatherDataViewModel {
        return ViewModelProvider(viewModelStoreOwner, MyViewModelFactory(repository))
            .get(WeatherDataViewModel::class.java)
    }
}