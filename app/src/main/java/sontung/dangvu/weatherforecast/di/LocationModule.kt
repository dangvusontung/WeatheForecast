package sontung.dangvu.weatherforecast.di

import android.content.Context
import android.location.Location
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import sontung.dangvu.weatherforecast.utils.LocationUtils

@Module
class LocationModule(private val context: Context) {

    @Provides
    fun provideLocation() : Location? {
        return LocationUtils.getLocation(context)
    }

    @Provides
    fun provideCompositeDisposable() : CompositeDisposable {
        return CompositeDisposable()
    }

}