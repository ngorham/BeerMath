package net.ngorham.liquidpackagingcalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
//import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


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
    private View layout;
    private RadioGroup fromRadioGroup;
    private RadioGroup toRadioGroup;
    private TextView fromSelectedText;
    private TextView toSelectedText;
    private EditText fromEditText;
    private EditText toEditText;
    private VolumeFragmentListener listener;
    private int fromRadioButtonId;
    private int toRadioButtonId;
    private double conversion;
    private String fromRadioButtonText;
    private String toRadioButtonText;

    public VolumeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment VolumeFragment.
     */
    public static VolumeFragment newInstance(int fromRadioButId, int toRadioButId) {
        VolumeFragment fragment = new VolumeFragment();
        Bundle args = new Bundle();
        args.putInt(Utilities.FROM_RADIO_BUTTON_ID, fromRadioButId);
        args.putInt(Utilities.TO_RADIO_BUTTON_ID, toRadioButId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof VolumeFragmentListener){
            listener = (VolumeFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement VolumeFragmentListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_volume, container, false);
        //Check Arguments
        if(getArguments() != null){
            setFromRadioButtonId(getArguments().getInt(Utilities.FROM_RADIO_BUTTON_ID));
            setToRadioButtonId(getArguments().getInt(Utilities.TO_RADIO_BUTTON_ID));
        }
        //Set up From RadioGroup
        fromRadioGroup = (RadioGroup) layout.findViewById(R.id.from_radio_group);
        toRadioGroup = (RadioGroup) layout.findViewById(R.id.to_radio_group);
        String[] units = getResources().getStringArray(R.array.volume_units);
        //Input TextView
        fromEditText = layout.findViewById(R.id.from_value_edit);
        //Output TextView
        toEditText = layout.findViewById(R.id.to_value_edit);
        //Create radio buttons
        for(int i = 0; i < units.length; i++){
            RadioButton fromRadioButton = new RadioButton(getActivity());
            RadioButton toRadioButton = new RadioButton(getActivity());
            fromRadioButton.setText(units[i]);
            toRadioButton.setText(units[i]);
            fromRadioButton.setTextSize(16);
            toRadioButton.setTextSize(16);
            fromRadioButton.setId(i);
            toRadioButton.setId(i);
            fromRadioButton.setChecked(false);
            toRadioButton.setChecked(false);
            fromRadioGroup.addView(fromRadioButton);
            toRadioGroup.addView(toRadioButton);
            if(i == getFromRadioButtonId()){
                setFromRadioButtonText(units[i]);
            }
            if(i == getToRadioButtonId()){
                setToRadioButtonText(units[i]);
            }
        }
        //Set default checked buttons
        fromRadioGroup.check(getFromRadioButtonId());
        toRadioGroup.check(getToRadioButtonId());
        //Set default selected texts
        fromSelectedText = layout.findViewById(R.id.from_selected_text);
        toSelectedText = layout.findViewById(R.id.to_selected_text);
        fromSelectedText.setText(getFromRadioButtonText());
        toSelectedText.setText(getToRadioButtonText());
        //Set listener to input textView
        fromEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String inputStr = fromEditText.getText().toString().trim();
                if(inputStr.length() > 0){
                    int fromId = fromRadioGroup.getCheckedRadioButtonId();
                    int toId = toRadioGroup.getCheckedRadioButtonId();
                    conversion = Double.parseDouble(inputStr);
                    listener.convert(toEditText, conversion, fromId, toId);
                } else {
                    toEditText.setText("0");
                }
            }
        });
        //Set listener to radio button groups
        //Set listener to from radio button group
        fromRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.findViewById(checkedId).isPressed()){
                    getArguments().putInt(Utilities.FROM_RADIO_BUTTON_ID, checkedId);
                    setFromRadioButtonId(checkedId);
                    RadioButton radioBtn = (RadioButton) getActivity().findViewById(checkedId);
                    fromSelectedText.setText(radioBtn.getText());
                    setFromRadioButtonText(radioBtn.getText().toString());
                    //check input value
                    String inputStr = fromEditText.getText().toString().trim();
                    if(inputStr.length() > 0){
                        conversion = Double.parseDouble(inputStr);
                        int toCheckedRadioButtonId = toRadioGroup.getCheckedRadioButtonId();
                        listener.convert(toEditText, conversion, checkedId, toCheckedRadioButtonId);
                    } else {
                        toEditText.setText("0");
                    }
                }
            }
        });
        //Set listener to to radio button group
        toRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(group.findViewById(checkedId).isPressed()){
                    getArguments().putInt(Utilities.TO_RADIO_BUTTON_ID, checkedId);
                    setToRadioButtonId(checkedId);
                    RadioButton radioBtn = (RadioButton) getActivity().findViewById(checkedId);
                    toSelectedText.setText(radioBtn.getText());
                    setToRadioButtonText(radioBtn.getText().toString());
                    //check input value
                    String inputStr = fromEditText.getText().toString().trim();
                    if(inputStr.length() > 0){
                        conversion = Double.parseDouble(inputStr);
                        int fromCheckedRadioButtonId = fromRadioGroup.getCheckedRadioButtonId();
                        listener.convert(toEditText, conversion, fromCheckedRadioButtonId, checkedId);
                    } else {
                        toEditText.setText("0");
                    }
                }
            }
        });
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void onResume(){
        super.onResume();
        fromRadioGroup.check(getFromRadioButtonId());
        toRadioGroup.check(getToRadioButtonId());
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void onStop(){
        super.onStop();
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) { //Handle action items
            case R.id.swap:
                swap();
                return true;
            case R.id.clear: //clear action
                clear();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Volume Fragment interface listener
    public interface VolumeFragmentListener{
        void convert(EditText output, double input, int fromIndex, int toIndex);
    }

    //Clear and set input and output TextViews to 0
    private void clear(){
        fromEditText.setText("");
        fromEditText.setHint("0");
        toEditText.setText("0");
    }

    //Swap from and to selected RadioButtons and TextViews
    private void swap(){
        int idTemp = getFromRadioButtonId();
        String textTemp = getFromRadioButtonText();
        fromRadioGroup.check(getToRadioButtonId());
        toRadioGroup.check(getFromRadioButtonId());
        setFromRadioButtonId(getToRadioButtonId());
        getArguments().putInt(Utilities.FROM_RADIO_BUTTON_ID, getFromRadioButtonId());
        setToRadioButtonId(idTemp);
        getArguments().putInt(Utilities.TO_RADIO_BUTTON_ID, getToRadioButtonId());
        fromSelectedText.setText(getToRadioButtonText());
        toSelectedText.setText(getFromRadioButtonText());
        setFromRadioButtonText(getToRadioButtonText());
        setToRadioButtonText(textTemp);
        String inputStr = fromEditText.getText().toString().trim();
        if(inputStr.length() > 0){
            conversion = Double.parseDouble(inputStr);
            listener.convert(toEditText, conversion, getFromRadioButtonId(), getToRadioButtonId());
        } else {
            toEditText.setText("0");
        }
    }

    //Set selected from radio button id
    private void setFromRadioButtonId(int radioButton){
        fromRadioButtonId = radioButton;
    }

    //Set selected to radio button id
    private void setToRadioButtonId(int radioButton){
        toRadioButtonId = radioButton;
    }

    //Set selected from radio button text
    private void setFromRadioButtonText(String text){
        fromRadioButtonText = text;
    }

    //Set selected to radio button text
    private void setToRadioButtonText(String text){
        toRadioButtonText = text;
    }

    //Get selected from radio button id
    private int getFromRadioButtonId(){ return fromRadioButtonId; }

    //Get selected to radio button id
    private int getToRadioButtonId(){ return toRadioButtonId; }

    //Get selected from radio button text
    private String getFromRadioButtonText(){ return fromRadioButtonText; }

    //Get selected to radio button text
    private String getToRadioButtonText(){ return toRadioButtonText; }
}
