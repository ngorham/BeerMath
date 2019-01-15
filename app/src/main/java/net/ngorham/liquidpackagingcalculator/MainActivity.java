package net.ngorham.liquidpackagingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Private constants
    private static final String TAG = "MainActivity";
    //Private variables
    private LiquidCalculator lq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "INSIDE onCreate: called");
        //Set up Liquid Calculator
        lq = new LiquidCalculator();
        //Set up textViews
        TextView ounceToOunce = (TextView) findViewById(R.id.ounce_to_ounce_text);
        TextView ounceToPint = (TextView) findViewById(R.id.ounce_to_pint_text);
        ounceToOunce.setText(String.valueOf(lq.ounceToOunce(1)));
        ounceToPint.setText(String.valueOf(lq.ounceToPint(36)));
    }
}
