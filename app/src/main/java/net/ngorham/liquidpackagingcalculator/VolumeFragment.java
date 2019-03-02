package net.ngorham.liquidpackagingcalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
    private VolumeFragmentListener listener;

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
        setHasOptionsMenu(true);
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
        //Input TextView
        final EditText inputTextView = layout.findViewById(R.id.from_value_edit);
        //Output TextView
        final EditText outputTextView = layout.findViewById(R.id.to_value_edit);
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
        //Set default checked buttons
        fromRadioGroup.check(0);
        toRadioGroup.check(0);
        //Set default selected texts
        TextView fromSelectedText = layout.findViewById(R.id.from_selected_text);
        TextView toSelectedText = layout.findViewById(R.id.to_selected_text);
        fromSelectedText.setText(R.string.default_selected_text);
        toSelectedText.setText(R.string.default_selected_text);
        //set listener to input textView
        inputTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() > 0){
                    int fromCheckedRadioButtonId = fromRadioGroup.getCheckedRadioButtonId();
                    int toCheckedRadioButtonId = toRadioGroup.getCheckedRadioButtonId();
                    double input = Double.parseDouble(inputTextView.getText().toString().trim());
                    listener.convert(outputTextView, input, fromCheckedRadioButtonId, toCheckedRadioButtonId);
                } else {
                    outputTextView.setText("0");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //set listener to radio button groups
        fromRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int fromCheckedRadioButtonId = fromRadioGroup.getCheckedRadioButtonId();
                RadioButton radioBtn = (RadioButton) getActivity().findViewById(fromCheckedRadioButtonId);
                TextView fromSelectedText = (TextView) getActivity().findViewById(R.id.from_selected_text);
                fromSelectedText.setText(radioBtn.getText());
                //check input value
                String inputStr = inputTextView.getText().toString().trim();
                if(inputStr.length() > 0){
                    double input = Double.parseDouble(inputStr);
                    int toCheckedRadioButtonId = toRadioGroup.getCheckedRadioButtonId();
                    listener.convert(outputTextView, input, fromCheckedRadioButtonId, toCheckedRadioButtonId);
                } else {
                    outputTextView.setText("0");
                }

            }
        });
        toRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int toCheckedRadioButtonId = toRadioGroup.getCheckedRadioButtonId();
                RadioButton radioBtn = (RadioButton) getActivity().findViewById(toCheckedRadioButtonId);
                TextView toSelectedText = (TextView) getActivity().findViewById(R.id.to_selected_text);
                toSelectedText.setText(radioBtn.getText());
                //check input value
                String inputStr = inputTextView.getText().toString().trim();
                if(inputStr.length() > 0){
                    double input = Double.parseDouble(inputStr);
                    int fromCheckedRadioButtonId = fromRadioGroup.getCheckedRadioButtonId();
                    listener.convert(outputTextView, input, fromCheckedRadioButtonId, toCheckedRadioButtonId);
                } else {
                    outputTextView.setText("0");
                }
            }
        });
        return layout;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) { //Handle action items
            case R.id.clear: //clear action
                Log.d(TAG, "INSIDE onOptionsItemSelected: clear option selected");
                clear();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "INSIDE onAttach: called");
        if (context instanceof VolumeFragmentListener){
            listener = (VolumeFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement VolumeFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "INSIDE onDetach: called");
        listener = null;
    }

    public interface VolumeFragmentListener{
        void convert(EditText output, double input, int fromIndex, int toIndex);
    }

    private void clear(){
        EditText input = (EditText) getActivity().findViewById(R.id.from_value_edit);
        EditText output = (EditText) getActivity().findViewById(R.id.to_value_edit);
        input.setText("");
        input.setHint("0");
        output.setText("0");
    }
}
