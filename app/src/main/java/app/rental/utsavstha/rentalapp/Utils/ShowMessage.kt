package app.rental.utsavstha.rentalapp.Utils

import android.widget.Toast

import app.rental.utsavstha.rentalapp.RentApplication

/**
 * Created by utsavstha on 8/19/17.
 */

object ShowMessage {
    fun toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(RentApplication.context, message, duration).show()
    }
}
