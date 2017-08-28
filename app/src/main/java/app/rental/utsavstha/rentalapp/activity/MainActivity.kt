package app.rental.utsavstha.rentalapp.activity

import android.graphics.Typeface
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import java.lang.reflect.Field

import app.rental.utsavstha.rentalapp.R
import app.rental.utsavstha.rentalapp.Utils.Dialogs
import app.rental.utsavstha.rentalapp.adapters.MainActivityAdapter
import app.rental.utsavstha.rentalapp.constants.AppConstants

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var viewPager: ViewPager
    private lateinit var mainActivityAdapter: MainActivityAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)
        disableShiftMode(bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        viewPager = findViewById(R.id.vp_tabs)

        mainActivityAdapter = MainActivityAdapter(supportFragmentManager)
        viewPager.adapter = mainActivityAdapter


    }

    // Method for disabling ShiftMode of BottomNavigationView
    private fun disableShiftMode(view: BottomNavigationView) {
        val menuView = view.getChildAt(0) as BottomNavigationMenuView
        try {
            val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
            shiftingMode.isAccessible = true
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.isAccessible = false
            for (i in 0 until menuView.childCount) {
                val item = menuView.getChildAt(i) as BottomNavigationItemView
                item.setShiftingMode(false)
                // set once again checked value, so view will be updated
                item.setChecked(item.itemData.isChecked)
            }
        } catch (e: NoSuchFieldException) {
            Log.e("BNVHelper", "Unable to get shift mode field", e)
        } catch (e: IllegalAccessException) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_alerts -> {
                viewPager.currentItem = 3
                Dialogs.showTapTargetView(AppConstants.IS_FIRST_TIME_ALERTS, "Alerts",
                        getString(R.string.alerts_description), this@MainActivity, R.id.action_alerts,
                        R.drawable.ic_action_alert)
            }

            R.id.action_listings -> {
                viewPager.currentItem = 0
                Dialogs.showTapTargetView(AppConstants.IS_FIRST_TIME_LISTINGS, "Listings",
                        getString(R.string.listings_description), this@MainActivity,
                        R.id.action_listings, R.drawable.ic_listing)
            }

            R.id.action_more -> {
                viewPager.currentItem = 4
                Dialogs.showTapTargetView(AppConstants.IS_FIRST_TIME_MORE, "More",
                        getString(R.string.more_description), this@MainActivity,
                        R.id.action_more, R.drawable.ic_action_more)
            }

            R.id.action_saved -> {
                viewPager.currentItem = 2
                Dialogs.showTapTargetView(AppConstants.IS_FIRST_TIME_SAVED, "Saved",
                        getString(R.string.saved_description), this@MainActivity,
                        R.id.action_saved, R.drawable.ic_heart_fill)
            }

            R.id.action_search -> {
                viewPager.currentItem = 1
                Dialogs.showTapTargetView(AppConstants.IS_FIRST_TIME_SEARCHED, "Search",
                        getString(R.string.search_description), this@MainActivity,
                        R.id.action_search, R.drawable.ic_search)
            }
        }
        return true
    }
}
