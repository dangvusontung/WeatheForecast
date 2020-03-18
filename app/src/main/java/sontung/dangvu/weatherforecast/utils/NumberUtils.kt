package sontung.dangvu.weatherforecast.utils

import java.text.SimpleDateFormat
import java.util.*

class NumberUtils {
    companion object {
        fun convertFtoC(f: Double): Double {
            return (f - 32) / 1.8
        }

        fun convertTimeToDate(time: Long): String {
            try {
                val sdf = SimpleDateFormat("dd/MM", Locale("vi", "VIETNAM"))
                return sdf.format(Date(time * 1000))

            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        fun convertTimeToHour(time: Long): String {
            try {
                val sdf = SimpleDateFormat("HH", Locale("vi", "VIETNAM"))
                return sdf.format(Date(time * 1000))
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }
    }
}