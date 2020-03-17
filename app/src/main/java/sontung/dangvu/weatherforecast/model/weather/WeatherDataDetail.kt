package sontung.dangvu.weatherforecast.model.weather

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
class WeatherDataDetail (
    @SerializedName("time")
    @PrimaryKey
    val time : Int,
    @SerializedName("summary")
    val summary : String,
    @SerializedName("temperature")
    val temperature : Double,
    @SerializedName("apparentTemperature")
    val apparentTemperature : Double
) {
    override fun toString(): String {
        return "WeatherDataDetail(time=$time, summary='$summary', temperature=$temperature, apparentTemperature=$apparentTemperature)\n"
    }
}