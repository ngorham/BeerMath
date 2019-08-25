package net.ngorham.liquidpackagingcalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import net.ngorham.liquidpackagingcalculator.iab.IabHelper;
import net.ngorham.liquidpackagingcalculator.iab.IabResult;
import net.ngorham.liquidpackagingcalculator.iab.Inventory;
import net.ngorham.liquidpackagingcalculator.iab.Purchase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Liquid Packaging Calculator
 * DonateActivity.java
 * Detail
 * Purpose: Display donation options
 *
 * @author Neil Gorham
 * @version 1.0 08/15/2019
 *
 */

public class DonateActivity extends AppCompatActivity {
    //Private constants
    private static final int DONATE_REQUEST_CODE = 6996;
    private static final String TAG = "DonateActivity";
    //Private variables
    private Context context;
    private RecyclerView recycler;
    private DonateListAdapter listAdapter;
    private List<String> mDonationOptions;
    private IabHelper mHelper;
    private Inventory mInventory;
    private String mPurchasePayload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);
        context = this;
        //Set up Action bar
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        setupBilling();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Shut down IAB
        if (mHelper != null){
            mHelper.dispose();
        }
        mHelper = null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
            // Not related to in-app billing, handle normally
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void setupBilling() {
        mDonationOptions = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.donation_options)));

        // Setup google play billing
        StringBuilder sb = new StringBuilder().append(getString(R.string.license_key_p1))
                .append(getString(R.string.license_key_p2))
                .append(getString(R.string.license_key_p3));

        mHelper = new IabHelper(context, sb.toString());
        try {
            mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
                @Override
                public void onIabSetupFinished(IabResult result) {
                    if (result.isSuccess()) {
                        // Try to get available inventory
                        mHelper.queryInventoryAsync(true, mDonationOptions, new IabHelper.QueryInventoryFinishedListener() {
                            @Override
                            public void onQueryInventoryFinished(IabResult result, Inventory inv) {
                                if (result.isSuccess()) {
                                    mInventory = inv;
                                    consumeExistingPurchases();
                                    displayDonationOptions();
                                }
                                else {
                                    shutdown(false);
                                }
                            }
                        });
                    }
                    else {
                        shutdown(false);
                    }
                }
            });
        }
        catch (Exception ex) {
            Toast.makeText(this, R.string.toast_error_billing_general, Toast.LENGTH_SHORT).show();
            mHelper = null;
            finish();
        }
    }

    /**
     * Display donation options to user
     */
    private void displayDonationOptions() {
        //Set up RecyclerView
        recycler = findViewById(R.id.recycler);
        //Set up Layout Manager
        recycler.setLayoutManager(new LinearLayoutManager(context));
        //Set up Adapter
        listAdapter = new DonateListAdapter(mInventory, getResources().getStringArray(R.array.donation_options));
        recycler.setAdapter(listAdapter);
        //Set up Adapter listener
        listAdapter.setListener(new DonateListAdapter.Listener() {
            @Override
            public void onClick(Object sku, int position) {
                donate((String) sku);
                Log.d(TAG, "donation clicked");
            }
        });
    }

    /**
     * Consume any existing purchases
     */
    private void consumeExistingPurchases() {
        List<Purchase> purchases = new ArrayList<Purchase>();

        // Check each sku, consume if owned
        for (String sku : mDonationOptions) {
            Purchase p = mInventory.getPurchase(sku);
            if (p != null) {
                purchases.add(p);
            }
        }

        mHelper.consumeAsync(purchases, new IabHelper.OnConsumeMultiFinishedListener() {
            @Override
            public void onConsumeMultiFinished(List<Purchase> purchases, List<IabResult> results) {}
        });
    }

    /**
     * Start Google Play billing flow, with specified product id (sku)
     *
     * @param productId product id of donation
     */
    private void donate(String productId) {
        mPurchasePayload = UUID.randomUUID().toString();
        mHelper.launchPurchaseFlow(this, productId, DONATE_REQUEST_CODE, mPurchaseFinishedListener, mPurchasePayload);
    }

    /**
     * Shutdown activity and display user confirmation
     *
     * @param success if the donation was successful
     */
    private void shutdown(boolean success) {
        if(success){
            Toast.makeText(this, R.string.toast_donation_successful, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, R.string.toast_error_billing_internet, Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    // Listener called when purchase has completed
    IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        @Override
        public void onIabPurchaseFinished(IabResult result, Purchase info) {

            if (result.isFailure()) {
                switch (result.getResponse()) {
                    case IabHelper.IABHELPER_USER_CANCELLED:
                        break;

                    default:
                        shutdown(false);
                        break;
                }
            }
            else {
                // Consume purchase so it can be done again and thank user
                mHelper.consumeAsync(info, mConsumeFinishedListener);
            }
        }
    };

    IabHelper.OnConsumeFinishedListener mConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener() {
        @Override
        public void onConsumeFinished(Purchase purchase, IabResult result) {
            // Purchase is successful, thank user and shutdown activity
            shutdown(true);
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
