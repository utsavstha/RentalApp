package app.rental.utsavstha.rentalapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import app.rental.utsavstha.rentalapp.fragments.AlertsFragment;
import app.rental.utsavstha.rentalapp.fragments.MapsFragment;
import app.rental.utsavstha.rentalapp.fragments.MoreFragment;
import app.rental.utsavstha.rentalapp.fragments.SearchListings;

/**
 * Created by utsavstha on 8/20/17.
 */

public class SearchPagerAdapter extends FragmentPagerAdapter {


    public SearchPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                return new SearchListings();
            case 1:
                return new MapsFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
