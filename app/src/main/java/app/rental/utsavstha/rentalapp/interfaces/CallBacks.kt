package app.rental.utsavstha.rentalapp.interfaces

import android.widget.ImageView

/**
 * Created by utsavstha on 8/19/17.
 */

interface CallBacks {
    interface ListingsAdapterCallBack {
        fun onListingClicked(position: Int)
    }

    interface AlertsAdapterCallBack {
        fun onAlertClicked(position: Int)
    }

    interface PostAdsCallBack {
        fun onImageClicked(position: Int, imageView: ImageView)
    }

}
