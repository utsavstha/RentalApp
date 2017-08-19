package app.rental.utsavstha.rentalapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

import app.rental.utsavstha.rentalapp.fragments.AlertsFragment;
import app.rental.utsavstha.rentalapp.fragments.ListingFragment;
import app.rental.utsavstha.rentalapp.fragments.MoreFragment;
import app.rental.utsavstha.rentalapp.fragments.SavedFragment;
import app.rental.utsavstha.rentalapp.fragments.SearchFragment;

/**
 * Created by utsavstha on 8/19/17.
 */

public class MainActivityAdapter extends FragmentPagerAdapter {


    public MainActivityAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return new ListingFragment();
            case 1:
                return new SearchFragment();
            case 2:
                return new SavedFragment();
            case 3:
                return new AlertsFragment();
            case 4:
                return new MoreFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
