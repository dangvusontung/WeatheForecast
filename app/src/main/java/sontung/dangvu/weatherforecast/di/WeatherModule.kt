package sontung.dangvu.weatherforecast.di

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class WeatherModule {

    @Provides
    @Singleton
    fun provideCompositeDisposable() : CompositeDisposable {
        return CompositeDisposable()
    }

}