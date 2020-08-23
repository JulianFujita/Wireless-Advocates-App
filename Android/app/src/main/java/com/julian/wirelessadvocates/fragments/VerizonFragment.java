package com.julian.wirelessadvocates.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.julian.wirelessadvocates.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VerizonFragment extends Fragment {

    private static final String TAG = "VerizonFragment";
    private Button ratePlans;

    public VerizonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_verizon, container, false);

        // Initialize buttons here
        ratePlans = root.findViewById(R.id.verizon_plans);
        ratePlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent);
            }
        });

        return root;
    }
}
