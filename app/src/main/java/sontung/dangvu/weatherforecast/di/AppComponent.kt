package sontung.dangvu.weatherforecast.di

import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component (modules = [WeatherModule::class])
interface AppComponent {
    fun provideCompositeDisposable() : CompositeDisposable
}