package app.rental.utsavstha.rentalapp.Utils

import android.content.Context
import android.widget.ImageView

import com.squareup.picasso.Picasso

import app.rental.utsavstha.rentalapp.RentApplication

/**
 * Created by utsavstha on 8/19/17.
 */

object ImageLoader {

    fun load(url: String, imageView: ImageView) {
        Picasso.with(RentApplication.context).load(url).into(imageView)
    }
}
