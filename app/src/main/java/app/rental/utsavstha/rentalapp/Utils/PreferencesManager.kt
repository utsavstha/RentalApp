package app.rental.utsavstha.rentalapp.Utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

import app.rental.utsavstha.rentalapp.RentApplication

/**
 * Created by utsavstha on 8/23/17.
 */

class PreferencesManager private constructor(c: Context) {
    private var preferences: SharedPreferences? = null

    init {
        preferences = PreferenceManager.getDefaultSharedPreferences(c)
    }

    fun setPreference(key: String, value: Any) {
        // The SharedPreferences editor - must use commit() to submit changes
        val editor = preferences!!.edit()
        if (value is Int)
            editor.putInt(key, value.toInt())
        else if (value is String)
            editor.putString(key, value)
        else if (value is Boolean)
            editor.putBoolean(key, value)
        else if (value is Long)
            editor.putLong(key, value)
        editor.commit()
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return preferences!!.getInt(key, defaultValue)
    }

    fun getString(key: String, defaultValue: String): String? {
        return preferences!!.getString(key, defaultValue)
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return preferences!!.getBoolean(key, defaultValue)
    }

    fun getLong(key: String, defaultValue: Long): Long {
        return preferences!!.getLong(key, defaultValue)
    }

    companion object {
        private var singleton: PreferencesManager? = null

        fun getPreferences(): PreferencesManager {
            if (singleton == null) {
                singleton = PreferencesManager(RentApplication.context!!)
            }
            return singleton as PreferencesManager
        }
    }
}
