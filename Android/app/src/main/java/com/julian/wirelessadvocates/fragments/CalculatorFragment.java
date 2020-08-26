package com.julian.wirelessadvocates.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends DialogFragment {

    private Spinner carriers;
    private Spinner plans;

    private Carriers c = new Carriers();

    public CalculatorFragment() {
        this.setCancelable(false);
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

        // TODO Finish setting up spinners and other fields
        changePlanList(root);

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
}
