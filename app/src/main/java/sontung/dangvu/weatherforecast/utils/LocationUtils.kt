package sontung.dangvu.weatherforecast.utils

import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.util.Log

private const val TAG = "LocationUtils"
class LocationUtils {

    companion object{

        fun getCityName(latitude : Double, longitude : Double, context: Context) : String{
            val geoCoder = Geocoder(context)
            val address = geoCoder.getFromLocation(latitude, longitude, 1)
            if(address.size != 0) {
                return address[0].adminArea
            }
            return "Unknown Location"
        }

        fun getCityName(location: Location, context: Context): String {
            val geoCoder = Geocoder(context)
            val latitude = location.latitude
            val longitude = location.longitude
            val address = geoCoder.getFromLocation(latitude, longitude, 1)

            return try {
                address[0].adminArea
            } catch (e : IllegalStateException) {
                "Unknown Location"
            } catch (e : IndexOutOfBoundsException) {
                "Unknown Location"
            }
        }
    }
}