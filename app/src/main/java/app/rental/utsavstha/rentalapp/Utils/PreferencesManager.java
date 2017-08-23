package app.rental.utsavstha.rentalapp.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import app.rental.utsavstha.rentalapp.RentApplication;

/**
 * Created by utsavstha on 8/23/17.
 */

public class PreferencesManager {
    private static PreferencesManager singleton = null;
    private SharedPreferences preferences = null;

    private PreferencesManager(Context c){
        preferences = PreferenceManager.getDefaultSharedPreferences(c);
    }

    public static PreferencesManager getPreferences(){
        if( singleton == null){
            singleton = new PreferencesManager(RentApplication.getContext());
        }
        return singleton;
    }

    public void setPreference(String key, Object value) {
        // The SharedPreferences editor - must use commit() to submit changes
        SharedPreferences.Editor editor = preferences.edit();
        if(value instanceof Integer )
            editor.putInt(key, ((Integer) value).intValue());
        else if (value instanceof String)
            editor.putString(key, (String)value);
        else if (value instanceof Boolean)
            editor.putBoolean(key, (Boolean)value);
        else if (value instanceof Long)
            editor.putLong(key, (Long)value);
        editor.commit();
    }

    public int getInt(String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    public String getString(String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }

    public long getLong(String key, long defaultValue) {
        return preferences.getLong(key, defaultValue);
    }
}
