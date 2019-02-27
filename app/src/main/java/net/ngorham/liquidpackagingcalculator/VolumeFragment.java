package net.ngorham.liquidpackagingcalculator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Liquid Packaging Calculator
 * VolumeFragment.java
 * Edit
 * Purpose: A simple {@link Fragment} subclass.
 * Use the {@link VolumeFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author Neil Gorham
 * @version 1.0 02/17/2019
 */
public class VolumeFragment extends Fragment {
    //Private constants
    private final String TAG = "VolumeFragment";

    //Private variables
    private RadioGroup fromRadioGroup;
    private RadioGroup toRadioGroup;

    public VolumeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment VolumeFragment.
     */
    public static VolumeFragment newInstance() {
        VolumeFragment fragment = new VolumeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "INSIDE onCreate: called");
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "INSIDE onCreateView: called");
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_volume, container, false);
        //Set up From RadioGroup
        fromRadioGroup = (RadioGroup) layout.findViewById(R.id.from_radio_group);
        toRadioGroup = (RadioGroup) layout.findViewById(R.id.to_radio_group);
        String[] units = getResources().getStringArray(R.array.volume_units);
        //create radio buttons
        for(int i = 0; i < units.length; i++){
            RadioButton fromRadioButton = new RadioButton(getActivity());
            RadioButton toRadioButton = new RadioButton(getActivity());
            fromRadioButton.setText(units[i]);
            toRadioButton.setText(units[i]);
            fromRadioButton.setId(i);
            toRadioButton.setId(i);
            fromRadioGroup.addView(fromRadioButton);
            toRadioGroup.addView(toRadioButton);
        }
        //set listener to radio button groups
        fromRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkedRadioButtonId = fromRadioGroup.getCheckedRadioButtonId();
                RadioButton radioBtn = (RadioButton) getActivity().findViewById(checkedRadioButtonId);
                TextView fromSelectedText = (TextView) getActivity().findViewById(R.id.from_selected_text);
                fromSelectedText.setText(radioBtn.getText());
                Toast.makeText(getActivity(), "id: " + checkedRadioButtonId + " " + radioBtn.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        toRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkedRadioButtonId = toRadioGroup.getCheckedRadioButtonId();
                RadioButton radioBtn = (RadioButton) getActivity().findViewById(checkedRadioButtonId);
                TextView toSelectedText = (TextView) getActivity().findViewById(R.id.to_selected_text);
                toSelectedText.setText(radioBtn.getText());
                Toast.makeText(getActivity(), "id: " + checkedRadioButtonId + " " + radioBtn.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        return layout;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
