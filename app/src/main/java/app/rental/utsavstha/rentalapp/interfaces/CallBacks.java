package app.rental.utsavstha.rentalapp.interfaces;

/**
 * Created by utsavstha on 8/19/17.
 */

public interface CallBacks {
    interface ListingsAdapterCallBack{
        void onListingClicked(int position);
    }

    interface AlertsAdapterCallBack{
        void onAlertClicked(int position);
    }

}
