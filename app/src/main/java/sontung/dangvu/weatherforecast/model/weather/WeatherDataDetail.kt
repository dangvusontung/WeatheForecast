package sontung.dangvu.weatherforecast.model.weather

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import sontung.dangvu.weatherforecast.utils.NumberUtils

@Entity
class WeatherDataDetail (
    @SerializedName("time")
    @PrimaryKey
    val time: Long,
    @SerializedName("summary")
    val summary : String,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("temperature")
    var temperature: Double,
    @SerializedName("apparentTemperature")
    var apparentTemperature: Double
) {

    fun convertFtoC() {
        this.temperature = NumberUtils.convertFtoC(temperature)
        this.apparentTemperature = NumberUtils.convertFtoC(apparentTemperature)
    }

    override fun toString(): String {
        return "WeatherDataDetail(time=$time, summary='$summary', temperature=$temperature, apparentTemperature=$apparentTemperature)\n"
    }
}