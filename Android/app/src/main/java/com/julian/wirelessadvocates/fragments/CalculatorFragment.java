package com.julian.wirelessadvocates.fragments;

import android.app.ActionBar;
import android.app.Dialog;
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
import android.widget.Spinner;

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

    private Spinner carriers;
    private Spinner plans;
    private Spinner lines;

    private Carriers c = new Carriers();

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

                // TODO fix crash when carrier is changed
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
                selectedPlan = c.VERIZON.getPlanByName(selection, planArrayList);
                break;
            case "AT&T":
                planArrayList = c.ATT.plans;
                selectedPlan = c.ATT.getPlanByName(selection, planArrayList);
                break;
            case "T-Mobile":
                planArrayList = c.T_MOBILE.plans;
                selectedPlan = c.T_MOBILE.getPlanByName(selection, planArrayList);
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
