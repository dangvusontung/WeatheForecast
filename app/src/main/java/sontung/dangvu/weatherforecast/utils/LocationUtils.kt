package sontung.dangvu.weatherforecast.utils

import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager

private const val TAG = "LocationUtils"
class LocationUtils() {

    companion object{
        fun getLocation(context: Context) : Location? {
            val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            try {
                return locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            } catch (e : SecurityException) {
                e.printStackTrace()
            }
            return null
        }

        fun getCityName(latitude : Double, longitude : Double, context: Context) : String{
            val geoCoder = Geocoder(context)
            val address = geoCoder.getFromLocation(latitude, longitude, 1)
            if(address.size != 0) {
                return address[0].adminArea
            }
            return ""
        }
    }
}