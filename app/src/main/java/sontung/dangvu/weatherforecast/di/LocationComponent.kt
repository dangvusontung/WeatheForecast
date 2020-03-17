package sontung.dangvu.weatherforecast.di

import android.location.Location
import dagger.Component

@Component (modules = [LocationModule::class])
interface LocationComponent {
    fun provideLocation() : Location?
}