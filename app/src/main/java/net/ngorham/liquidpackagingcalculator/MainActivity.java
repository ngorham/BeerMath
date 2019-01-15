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
        //Ounces
        /*
        TextView ounceToOunce = (TextView) findViewById(R.id.ounce_to_ounce_text);
        TextView ounceToPint = (TextView) findViewById(R.id.ounce_to_pint_text);
        TextView ounceToGallon = (TextView) findViewById(R.id.ounce_to_gallon_text);
        TextView ounceToBarrel = (TextView) findViewById(R.id.ounce_to_barrel_text);
        TextView ounceToMilliliter = (TextView) findViewById(R.id.ounce_to_milliliter_text);
        TextView ounceToLiter = (TextView) findViewById(R.id.ounce_to_liter_text);
        ounceToOunce.setText(String.valueOf(lq.ounceToOunce(1)));
        ounceToPint.setText(String.valueOf(lq.ounceToPint(1)));
        ounceToGallon.setText(String.valueOf(lq.ounceToGallon(1)));
        ounceToBarrel.setText(String.valueOf(lq.ounceToBarrel(1)));
        ounceToMilliliter.setText(String.valueOf(lq.ounceToMilliliter(1)));
        ounceToLiter.setText(String.valueOf(lq.ounceToLiter(1)));
        //Pints
        TextView pintToOunce = (TextView) findViewById(R.id.pint_to_ounce_text);
        TextView pintToPint = (TextView) findViewById(R.id.pint_to_pint_text);
        TextView pintToGallon = (TextView) findViewById(R.id.pint_to_gallon_text);
        TextView pintToBarrel = (TextView) findViewById(R.id.pint_to_barrel_text);
        TextView pintToMilliliter = (TextView) findViewById(R.id.pint_to_milliliter_text);
        TextView pintToLiter = (TextView) findViewById(R.id.pint_to_liter_text);
        pintToOunce.setText(String.valueOf(lq.pintToOunce(1)));
        pintToPint.setText(String.valueOf(lq.pintToPint(1)));
        pintToGallon.setText(String.valueOf(lq.pintToGallon(1)));
        pintToBarrel.setText(String.valueOf(lq.pintToBarrel(1)));
        pintToMilliliter.setText(String.valueOf(lq.pintToMilliliter(1)));
        pintToLiter.setText(String.valueOf(lq.pintToLiter(1)));*/
        //Gallons
        TextView gallonToOunce = (TextView) findViewById(R.id.gallon_to_ounce_text);
        TextView gallonToPint = (TextView) findViewById(R.id.gallon_to_pint_text);
        TextView gallonToGallon = (TextView) findViewById(R.id.gallon_to_gallon_text);
        TextView gallonToBarrel = (TextView) findViewById(R.id.gallon_to_barrel_text);
        TextView gallonToMilliliter = (TextView) findViewById(R.id.gallon_to_milliliter_text);
        TextView gallonToLiter = (TextView) findViewById(R.id.gallon_to_liter_text);
        gallonToOunce.setText(String.valueOf(lq.gallonToOunce(1)));
        gallonToPint.setText(String.valueOf(lq.gallonToPint(1)));
        gallonToGallon.setText(String.valueOf(lq.gallonToGallon(1)));
        gallonToBarrel.setText(String.valueOf(lq.gallonToBarrel(1)));
        gallonToMilliliter.setText(String.valueOf(lq.gallonToMilliliter(1)));
        gallonToLiter.setText(String.valueOf(lq.gallonToLiter(1)));
    }
}
