package app.rental.utsavstha.rentalapp

import android.app.Application
import android.content.Context

/**
 * Created by utsavstha on 8/19/17.
 */

class RentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {

        private var instance: RentApplication? = null
        val context: Context?
            get() = instance
    }

}
