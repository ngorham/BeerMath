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
        switch (item.getItemId()) { //Handle action items
            case R.id.rate_us: //Rate us action
                Utilities.rateUs(context);
                return true;
            case R.id.app_share: //Share action
                Utilities.shareApp(context);
                return true;
            case R.id.app_about: //About action
                Utilities.aboutDialog(context);
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
                    }
            }
    };

    //VolumeFragmentListener functions
    @Override
    public void convert(EditText output, double input, int fromIndex, int toIndex){
        //Get calculation
        double conversion = calculations[fromIndex][toIndex].calculate(input);
        if(output != null){
            //set output text to calculation
            output.setText(String.valueOf(conversion));
        }
    }
}
