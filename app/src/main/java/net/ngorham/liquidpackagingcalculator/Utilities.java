package net.ngorham.liquidpackagingcalculator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Liquid Packaging Calculator
 * Utilities.java
 * Utility
 * Purpose: Collection of utilities
 *
 * @author Neil Gorham
 * @version 1.0 02/17/2019
 *
 */

public class Utilities {
    //Display About AlertDialog
    public static void aboutDialog(final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.app_about);
        builder.setIcon(R.drawable.ic_information_black_18dp);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_about, null);
        builder.setView(view);
        TextView signature = view.findViewById(R.id.signature_text);
        signature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String website = context.getResources().getString(R.string.website);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                context.startActivity(webIntent);
            }
        });
        builder.setCancelable(true);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    //Share intent
    public static void shareApp(Context context){
        String download = context.getResources().getString(R.string.download_link);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, download);
        context.startActivity(intent);
    }
    //Rate us
    public static void rateUs(Context context){
        String site = context.getResources().getString(R.string.play_store);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(site));
        context.startActivity(intent);
    }
}
