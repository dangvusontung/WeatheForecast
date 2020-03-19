package sontung.dangvu.weatherforecast.di

import android.content.Context
import android.location.Location
import dagger.Module
import dagger.Provides
import sontung.dangvu.weatherforecast.utils.LocationUtils

@Module
class LocationModule(private val context: Context) {

    @Provides
    fun provideLocation() : Location? {
        return LocationUtils.getLocation(context)
    }

}