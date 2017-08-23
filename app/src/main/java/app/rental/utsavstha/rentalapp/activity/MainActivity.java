package app.rental.utsavstha.rentalapp.activity;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;


import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.lang.reflect.Field;

import app.rental.utsavstha.rentalapp.R;
import app.rental.utsavstha.rentalapp.Utils.Dialogs;
import app.rental.utsavstha.rentalapp.adapters.MainActivityAdapter;
import app.rental.utsavstha.rentalapp.constants.AppConstants;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    MainActivityAdapter mainActivityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        viewPager = findViewById(R.id.vp_tabs);

        mainActivityAdapter = new MainActivityAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainActivityAdapter);



    }

    // Method for disabling ShiftMode of BottomNavigationView
    @SuppressWarnings("RestrictedApi")
    private void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_alerts:
                viewPager.setCurrentItem(3);
                Dialogs.showTapTargetView(AppConstants.IS_FIRST_TIME_ALERTS,"Alerts",
                        getString(R.string.alerts_description), MainActivity.this, R.id.action_alerts,
                        R.drawable.ic_action_alert);
                break;

            case R.id.action_listings:
                viewPager.setCurrentItem(0);
                Dialogs.showTapTargetView(AppConstants.IS_FIRST_TIME_LISTINGS, "Listings",
                        getString(R.string.listings_description), MainActivity.this,
                        R.id.action_listings, R.drawable.ic_listing);
                break;

            case R.id.action_more:
                viewPager.setCurrentItem(4);
                Dialogs.showTapTargetView(AppConstants.IS_FIRST_TIME_MORE, "More",
                        getString(R.string.more_description), MainActivity.this,
                        R.id.action_more, R.drawable.ic_action_more);
                break;

            case R.id.action_saved:
                viewPager.setCurrentItem(2);
                Dialogs.showTapTargetView(AppConstants.IS_FIRST_TIME_SAVED, "Saved",
                        getString(R.string.saved_description), MainActivity.this,
                        R.id.action_saved, R.drawable.ic_heart_fill);
                break;

            case R.id.action_search:
                viewPager.setCurrentItem(1);
                Dialogs.showTapTargetView(AppConstants.IS_FIRST_TIME_SAVED, "Search",
                        getString(R.string.search_description), MainActivity.this,
                        R.id.action_search, R.drawable.ic_search);
                break;

        }
        return true;
    }
}
