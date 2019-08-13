package net.ngorham.liquidpackagingcalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * Liquid Packaging Calculator
 * MainActivity.java
 * Detail
 * Purpose: Display two radio selections of input and output of unit conversion
 *
 * @author Neil Gorham
 * @version 1.0 02/17/2019
 *
 */

public class MainActivity extends AppCompatActivity
    implements VolumeFragment.VolumeFragmentListener {
    //Private constants
    private static final String TAG = "MainActivity";
    //Private variables
    private Context context;
    //Fragment variables
    private Fragment volumeFrag;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private LiquidCalculator lq;
    private Preferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "INSIDE onCreate: called");
        context = this;
        //Set up Action bar
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        if(savedInstanceState == null) {
            //Set up Fragment layout
            setUpFragmentLayout(0, 0);
        }
        //Set up Liquid Calculator
        lq = new LiquidCalculator();
        //Set up Preferences
        prefs = Preferences.getInstance(context);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d(TAG, "INSIDE onPostCreate: called");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "INSIDE onStart: called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "INSIDE onResume: called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "INSIDE onPause: called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "INSIDE onStop: called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "INSIDE onDestroy: called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "INSIDE onRestart: called");
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "INSIDE onBackPressed: called");
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //Display icons and text in overflow menu
        //code found on stackoverflow
        //https://stackoverflow.com/questions/18374183/how-to-show-icons-in-overflow-menu-in-actionbar
        if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
            try {
                Method m = menu.getClass().getDeclaredMethod(
                        "setOptionalIconsVisible", Boolean.TYPE);
                m.setAccessible(true);
                m.invoke(menu, true);
            } catch (NoSuchMethodException e) {
                Log.e("onCreateOptionsMenu", "Did not attach icons", e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return super.onCreateOptionsMenu(menu);
    }

    //Call when user clicks an item in action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent settingsIntent;
        switch (item.getItemId()) { //Handle action items
            case R.id.app_rate: //Rate us action
                Utilities.rateUs(context);
                return true;
            case R.id.app_share: //Share action
                Utilities.shareApp(context);
                return true;
            case R.id.app_donate: //Donate action
                Utilities.donate(context);
                return true;
            case R.id.app_about: //About action
                Utilities.aboutDialog(context);
                return true;
            case R.id.app_settings: //Settings action
                settingsIntent = new Intent(context, SettingsActivity.class);
                startActivity(settingsIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Called when invalidateOptionsMenu() is called
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    //Set up Fragment layout
    private void setUpFragmentLayout(int fromRadioButtonId, int toRadioButtonId){
        volumeFrag = VolumeFragment.newInstance(fromRadioButtonId, toRadioButtonId);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.content_frame, volumeFrag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    //Interface for mapping liquid calculator functions
    private interface Calculation{
        double calculate(double input);
    }
    //2-dimensional array of conversion functions
    private Calculation[][] calculations = new Calculation[][]{
            {//Ounce conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.ounceToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.ounceToFiftyLiterKeg(input);
                        }
                    }
            },
            {//Pint conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.pintToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToFiftyLiterKeg(input);
                        }
                    }
            },
            {//Gallon conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.gallonToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.gallonToFiftyLiterKeg(input);
                        }
                    }
            },
            {//Barrel conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.barrelToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.barrelToFiftyLiterKeg(input);
                        }
                    }
            },
            {//Milliliter conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.milliliterToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.milliliterToFiftyLiterKeg(input);
                        }
                    }
            },
            {//Liter conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.literToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.literToFiftyLiterKeg(input);
                        }
                    }
            },
            {//8oz can conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.eightOunceToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eightOunceToFiftyLiterKeg(input);
                        }
                    }
            },
            {//11.5oz can conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.elevenOunceToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.elevenOunceToFiftyLiterKeg(input);
                        }
                    }
            },
            {//12oz can/bottle conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.twelveOunceToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twelveOunceToFiftyLiterKeg(input);
                        }
                    }
            },
            {//16oz can conversion functions
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.pintToFiftyLiterKeg(input);
                        }
                    }
            },
            {//22oz bottle conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.twentyTwoOunceToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyTwoOunceToFiftyLiterKeg(input);
                        }
                    }
            },
            {//32oz crowler conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.crowlerToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.crowlerToFiftyLiterKeg(input);
                        }
                    }
            },
            {//64oz growler conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.growlerToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.growlerToFiftyLiterKeg(input);
                        }
                    }
            },
            {//375mL bottle conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.threeSevenFiveMLToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.threeSevenFiveMLToFiftyLiterKeg(input);
                        }
                    }
            },
            {//500mL bottle conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.fiveHundredMLToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiveHundredMLToFiftyLiterKeg(input);
                        }
                    }
            },
            {//750mL bottle conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.sevenFiftyMLToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sevenFiftyMLToFiftyLiterKeg(input);
                        }
                    }
            },
            {//Mini keg conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.miniKegToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.miniKegToFiftyLiterKeg(input);
                        }
                    }
            },
            {//Eighth keg conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.eighthKegToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.eighthKegToFiftyLiterKeg(input);
                        }
                    }
            },
            {//Corny keg conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.cornyKegToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.cornyKegToFiftyLiterKeg(input);
                        }
                    }
            },
            {//Sixtel keg conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.sixtelKegToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.sixtelKegToFiftyLiterKeg(input);
                        }
                    }
            },
            {//Quarter keg conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.quarterKegToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.quarterKegToFiftyLiterKeg(input);
                        }
                    }
            },
            {//Half keg conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.halfKegToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.halfKegToFiftyLiterKeg(input);
                        }
                    }
            },
            {//20L keg conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.twentyLiterKegToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.twentyLiterKegToFiftyLiterKeg(input);
                        }
                    }
            },
            {//30L keg conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.thirtyLiterKegToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.thirtyLiterKegToFiftyLiterKeg(input);
                        }
                    }
            },
            {//50L keg conversion functions
                new Calculation() {
                    @Override
                    public double calculate(double input) {
                        return lq.fiftyLiterKegToOunce(input);
                    }
                },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToGallon(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToBarrel(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToMilliliter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToLiter(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToEightOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToElevenOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToTwelveOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToPint(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToTwentyTwoOunce(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToCrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToGrowler(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToThreeSevenFiveML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToFiveHundredML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToSevenFiftyML(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToMiniKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToEighthKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToCornyKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToSixtelKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToQuarterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToHalfKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToTwentyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToThirtyLiterKeg(input);
                        }
                    },
                    new Calculation() {
                        @Override
                        public double calculate(double input) {
                            return lq.fiftyLiterKegToFiftyLiterKeg(input);
                        }
                    }
            }
    };

    //Returns the DecimalFormat
    private DecimalFormat getDecimalFormat(){
        DecimalFormat formatter = new DecimalFormat();

        //Set maximum number of decimal places
        formatter.setMaximumFractionDigits(prefs.getNumDecimals());

        //Set group and decimal separators
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
        symbols.setDecimalSeparator(prefs.getDecimalSeparator().charAt(0));

        String groupSeparator = prefs.getGroupSeparator();
        boolean isSeparatorUsed = !groupSeparator.equals(context.getString(R.string.group_separator_none));
        formatter.setGroupingUsed(isSeparatorUsed);
        if (isSeparatorUsed) {
            symbols.setGroupingSeparator(groupSeparator.charAt(0));
        }

        formatter.setDecimalFormatSymbols(symbols);
        return formatter;
    }

    //VolumeFragmentListener functions
    @Override
    public void convert(EditText output, double input, int fromIndex, int toIndex){
        //Get calculation
        double conversion = calculations[fromIndex][toIndex].calculate(input);
        if(output != null){
            //set output text to calculation
            output.setText(getDecimalFormat().format(conversion));
        }
    }
}
