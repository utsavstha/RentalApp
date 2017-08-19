package app.rental.utsavstha.rentalapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by utsavstha on 8/19/17.
 */

public class RentApplication extends Application {

    private static RentApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
    public static Context getContext() {
        return instance;
    }

}
