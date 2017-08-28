package app.rental.utsavstha.rentalapp.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import app.rental.utsavstha.rentalapp.fragments.AlertsFragment
import app.rental.utsavstha.rentalapp.fragments.MapsFragment
import app.rental.utsavstha.rentalapp.fragments.MoreFragment
import app.rental.utsavstha.rentalapp.fragments.SearchListings

/**
 * Created by utsavstha on 8/20/17.
 */

class SearchPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(index: Int): Fragment? {
        when (index) {
            0 -> return SearchListings()
            1 -> return MapsFragment()
        }

        return null
    }

    override fun getCount(): Int {
        return 2
    }
}
