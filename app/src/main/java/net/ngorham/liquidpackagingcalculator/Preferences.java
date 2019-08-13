package net.ngorham.liquidpackagingcalculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Liquid Packaging Calculator
 * Preferences.java
 * POJO
 * Purpose: Storage and access of SharedPreferences
 *
 * @author Neil Gorham
 * @version 1.0 08/12/2019
 *
 */

public class Preferences {
    //Public constants
    public static final String PREF_NUM_DECIMALS = "num_decimals";
    public static final String PREF_GROUP_SEPARATOR = "group_separator";
    public static final String PREF_DECIMAL_SEPARATOR = "decimal_separator";
    //Private variables
    private static Preferences instance;
    private SharedPreferences prefs;
    private Context context;

    /**
     * Factory method for instantiating a new instance of Preferences
     *
     * @return A new instance of Preferences.
     */
    public static Preferences getInstance(Context context){
        if(instance == null){
            instance = new Preferences(context.getApplicationContext());
        }
        return instance;
    }

    //Private default constructor
    private Preferences(Context context){
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        this.context = context;

    }

    //Get SharedPreferences
    public SharedPreferences getPreferences(){
        return prefs;
    }

    //Get number of decimal places
    public int getNumDecimals(){
        return Integer.parseInt(prefs.getString(PREF_NUM_DECIMALS, context.getString(R.string.pref_default_num_decimals)));
    }

    //Get group separator
    public String getGroupSeparator(){
        return prefs.getString(PREF_GROUP_SEPARATOR, context.getString(R.string.pref_default_group_separator));
    }

    //Get decimal separator
    public String getDecimalSeparator(){
        return prefs.getString(PREF_DECIMAL_SEPARATOR, context.getString(R.string.pref_default_decimal_separator));
    }
}
