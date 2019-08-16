package net.ngorham.liquidpackagingcalculator;

import android.content.Context;
import android.preference.Preference;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

/**
 * Liquid Packaging Calculator
 * SettingsActivity.java
 * Detail
 * Purpose: Display settings preferences
 *
 * @author Neil Gorham
 * @version 1.0 08/10/2019
 *
 */

public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }

    public static class SettingsFragment extends PreferenceFragment {
        //Private variables
        private Context context;
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
            context = getActivity();

            Preference appShare = findPreference("app_share");
            appShare.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Utilities.shareApp(context);
                    return true;
                }
            });

            Preference appDonate = findPreference("app_donate");
            appDonate.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener(){
                @Override
                public boolean onPreferenceClick(Preference preference){
                    Utilities.donate(context);
                    return true;
                }
            });
        }
    }
}
