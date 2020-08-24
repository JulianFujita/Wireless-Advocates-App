package com.julian.wirelessadvocates.fragments;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.julian.wirelessadvocates.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends DialogFragment {

    private Spinner carriers;
    private Spinner plans;

    public CalculatorFragment() {
        // Required empty public constructor
        this.setCancelable(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_calculator, container, false);

        // Initialize variables here
        carriers = root.findViewById(R.id.spinner_carrier);
        List<String> list = new ArrayList<>();
        list.add("Verizon");
        list.add("AT&T");
        list.add("T-Mobile");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carriers.setAdapter(adapter);

        plans = root.findViewById(R.id.spinner_plans);
        // TODO Finish setting up spinners and other fields


        return root;
    }
}
