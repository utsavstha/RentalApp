package app.rental.utsavstha.rentalapp.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.ListFragment

import app.rental.utsavstha.rentalapp.fragments.AlertsFragment
import app.rental.utsavstha.rentalapp.fragments.ListingFragment
import app.rental.utsavstha.rentalapp.fragments.MoreFragment
import app.rental.utsavstha.rentalapp.fragments.SavedFragment
import app.rental.utsavstha.rentalapp.fragments.SearchFragment

/**
 * Created by utsavstha on 8/19/17.
 */

class MainActivityAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(index: Int): Fragment? {
        when (index) {
            0 -> return ListingFragment()
            1 -> return SearchFragment()
            2 -> return SavedFragment()
            3 -> return AlertsFragment()
            4 -> return MoreFragment()
        }

        return null
    }

    override fun getCount(): Int {
        return 5
    }
}
