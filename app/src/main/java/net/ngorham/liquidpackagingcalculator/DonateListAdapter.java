package net.ngorham.liquidpackagingcalculator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.ngorham.liquidpackagingcalculator.iab.Inventory;
import net.ngorham.liquidpackagingcalculator.iab.SkuDetails;

/**
 * Liquid Packaging Calculator
 * DonateListAdapter.java
 * Utility
 * Purpose: Displays list of donation options in a RecyclerView
 *
 * @author Neil Gorham
 * @version 1.0 08/15/2019
 *
 */

public final class DonateListAdapter extends  RecyclerView.Adapter<DonateListAdapter.ViewHolder> {
    //Private variables
    private Inventory inventory;
    private String[] donationOptions;
    private Listener listener;

    public interface Listener{
        void onClick(Object donate, int position);
    }

    //Constructor
    public DonateListAdapter(Inventory inventory, String[] donationOptions) {
        this.inventory = inventory;
        this.donationOptions = donationOptions;
    }

    //Set onClick Listener
    public void setListener(Listener listener){ this.listener = listener; }

    public final class ViewHolder extends RecyclerView.ViewHolder {
        public TextView description;
        public TextView price;

        public ViewHolder(View v){
            super(v);
            description = (TextView) v.findViewById(R.id.billing_donation_description);
            price = (TextView) v.findViewById(R.id.billing_donation_price);
            v.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(listener != null){listener.onClick(donationOptions[getAdapterPosition()], getAdapterPosition());}
                }
            });
        }
    }

    @Override
    public DonateListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_donation, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DonateListAdapter.ViewHolder vh, int position) {
        SkuDetails details = inventory.getSkuDetails(donationOptions[position]);
        vh.description.setText(details.getDescription());
        vh.price.setText(details.getPrice());
    }

    @Override
    public int getItemCount() {
        return donationOptions.length;
    }
}
