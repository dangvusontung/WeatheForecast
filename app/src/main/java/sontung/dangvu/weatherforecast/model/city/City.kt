package sontung.dangvu.weatherforecast.model.city

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "city_table")
data class City(
    @PrimaryKey
    val cityName : String,
    val cityLatitude : String,
    val cityLongitude : String
) {
    override fun toString(): String {
        return "City(cityName='$cityName', cityLatitude='$cityLatitude', cityLongitude='$cityLongitude')"
    }
}