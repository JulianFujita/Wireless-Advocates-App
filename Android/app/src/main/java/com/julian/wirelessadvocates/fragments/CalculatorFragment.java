package com.julian.wirelessadvocates.fragments;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.julian.wirelessadvocates.MainActivity;
import com.julian.wirelessadvocates.R;
import com.julian.wirelessadvocates.models.Carrier;
import com.julian.wirelessadvocates.models.Carriers;
import com.julian.wirelessadvocates.models.Plan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends DialogFragment {

    private static final String TAG = "CalculatorFragment";

    private Spinner carriers;
    private Spinner plans;
    private Spinner lines;
    private Button backButton;
    private Button calculateButton;
    private EditText phonePrice;
    private EditText promotionPrice;

    private Carriers c = new Carriers();
    private CalculatorBackButton mCallback;

    public interface CalculatorBackButton{
        public void dismissDialog();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mCallback = (CalculatorBackButton)context;
    }

    public CalculatorFragment() {
        this.setCancelable(false);
    }

    @Override
    public void onStart() {
        super.onStart();
        this.getDialog().getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_calculator, container, false);

        // Initialize variables here
        phonePrice = root.findViewById(R.id.phone_edittext);
        promotionPrice = root.findViewById(R.id.promotion_edittext);
        backButton = root.findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.dismissDialog();
            }
        });
        calculateButton = root.findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phonePrice.getText().toString().length() != 0 && promotionPrice.getText().toString().length() != 0)
                {
                    // Variables
                    String selectedCarrier = carriers.getSelectedItem().toString();
                    Carrier carrier = new Carrier();
                    float monthlyBill = 0;

                    String plan = plans.getSelectedItem().toString();
                    int line = Integer.parseInt(lines.getSelectedItem().toString().substring(0, 1));
                    float phone = Float.parseFloat(phonePrice.getText().toString());
                    float promo = Float.parseFloat(promotionPrice.getText().toString());

                    // Get carrier
                    switch(selectedCarrier){
                        case "Verizon":
                            carrier = c.VERIZON;
                            break;
                        case "AT&T":
                            carrier = c.ATT;
                            break;
                        case "T-Mobile":
                            carrier = c.T_MOBILE;
                            break;
                    }
                    float linePrice = carrier.getPlanByName(plan).priceMap.get(line);

                    // Calculate monthly bill
                    monthlyBill = (linePrice * line) + ((phone - promo) / carrier.monthsAgreement);


                    // Set up string array for displaying
                    final String[] result = {
                            selectedCarrier + " (" + plan + ")",
                            line + " Line(s)\t$" + String.format("%.2f", linePrice) + "/Line",
                            "",
                            "Data: $" + String.format("%.2f", linePrice * line) + "/Month",
                            "Phones: $" + String.format("%.2f", ((phone - promo) / carrier.monthsAgreement)) + "/Month",
                            "Applied Promotions: $" + String.format("%.2f", promo),
                            "",
                            "Total Monthly Bill: $" + String.format("%.2f", monthlyBill)
                    };
                    // Build AlertDialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    AlertDialog dialog;

                    builder.setTitle("Monthly Bill Breakdown");
                    builder.setNeutralButton("Back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setItems(result, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Button functinoality for monthly bill calcuation
                        }
                    });

                    dialog = builder.create();
                    dialog.show();
                }
                else{
                    Toast.makeText(getContext(), "Please enter your data correctly", Toast.LENGTH_SHORT).show();
                }
                
                
            }
        });

        // Carriers Spinner
        carriers = root.findViewById(R.id.spinner_carrier);
        carriers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                changePlanList(root);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) { }

        });
        List<String> carrierList = new ArrayList<>();
        carrierList.add("Verizon");
        carrierList.add("AT&T");
        carrierList.add("T-Mobile");
        ArrayAdapter<String> carrierAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, carrierList);
        carrierAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carriers.setAdapter(carrierAdapter);

        // Plans Spinner
        changePlanList(root);
        // Lines Spinner

        changeLineList(root, plans.getSelectedItem().toString());
        plans.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                changeLineList(root, plans.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) { }

        });

        return root;
    }

    public void changePlanList(View root){
        String carrierSelection = carriers.getSelectedItem().toString();
        ArrayList<Plan> planArrayList = new ArrayList<>();
        switch(carrierSelection){
            case "Verizon":
                planArrayList = c.VERIZON.plans;
                break;
            case "AT&T":
                planArrayList = c.ATT.plans;
                break;
            case "T-Mobile":
                planArrayList = c.T_MOBILE.plans;
                break;
        }

        plans = root.findViewById(R.id.spinner_plans);
        List<String> planList = new ArrayList<>();
        for(int i = 0; i < planArrayList.size(); i++){
            planList.add(planArrayList.get(i).name);
        }
        ArrayAdapter<String> planAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, planList);
        planAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        plans.setAdapter(planAdapter);
    }

    public void changeLineList(View root, String selection){
        String carrierSelection = carriers.getSelectedItem().toString();
        ArrayList<Plan> planArrayList = new ArrayList<>();
        Plan selectedPlan = new Plan();
        switch(carrierSelection){
            case "Verizon":
                planArrayList = c.VERIZON.plans;
                selectedPlan = c.VERIZON.getPlanByName(selection);
                break;
            case "AT&T":
                planArrayList = c.ATT.plans;
                selectedPlan = c.ATT.getPlanByName(selection);
                break;
            case "T-Mobile":
                planArrayList = c.T_MOBILE.plans;
                selectedPlan = c.T_MOBILE.getPlanByName(selection);
                break;
        }

        lines = root.findViewById(R.id.spinner_lines);
        Object[] keySet = selectedPlan.priceMap.keySet().toArray();
        ArrayList<String> lineList = new ArrayList<>();

        for(int i = 0; i < keySet.length; i++){
            lineList.add(keySet[i].toString() + " Lines");
        }
        ArrayAdapter<String> planAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, lineList);
        planAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lines.setAdapter(planAdapter);
    }
}
