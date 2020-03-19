package sontung.dangvu.weatherforecast.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class WeatherModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideCompositeDisposable() : CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    fun provideApplication(): Context {
        return context
    }

}