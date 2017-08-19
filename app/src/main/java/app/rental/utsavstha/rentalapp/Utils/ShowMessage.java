package app.rental.utsavstha.rentalapp.Utils;

import android.widget.Toast;

import app.rental.utsavstha.rentalapp.RentApplication;

/**
 * Created by utsavstha on 8/19/17.
 */

public class ShowMessage {
    public static void toast(String message){
        Toast.makeText(RentApplication.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
