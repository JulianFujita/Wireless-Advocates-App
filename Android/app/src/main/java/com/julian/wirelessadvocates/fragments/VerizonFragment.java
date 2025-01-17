package com.julian.wirelessadvocates.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
    private Button website;
    private Button ratePlans;
    private Button militaryPlans;
    private Button coverageMap;
    private Button coverage5G;
    private Button support;
    private Button description;

    public VerizonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_verizon, container, false);

        // Initialize buttons here
        website = root.findViewById(R.id.verizon_website);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.verizonwireless.com"));
                startActivity(browserIntent);
            }
        });
        ratePlans = root.findViewById(R.id.verizon_plans);
        ratePlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.verizonwireless.com/plans"));
                startActivity(browserIntent);
            }
        });
        militaryPlans = root.findViewById(R.id.verizon_military_plans);
        militaryPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.verizonwireless.com/military"));
                startActivity(browserIntent);
            }
        });
        coverageMap = root.findViewById(R.id.verizon_coverage_map);
        coverageMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.verizonwireless.com/featured/better-matters"));
                startActivity(browserIntent);
            }
        });
        coverage5G = root.findViewById(R.id.verizon_5g_coverage_map);
        coverage5G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.verizonwireless.com/5g/coverage-map"));
                startActivity(browserIntent);
            }
        });
        description = root.findViewById(R.id.verizon_description);
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog;
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                String[] strings = {
                        "Activation Fee: $30.00/Device",
                        "Upgrade Fee: $40.00/Device",
                        "Extra Device Fee: $10.00/Device",
                        "Rate Plans:  Mix & Match",
                        "Services: Disney+ and Apple Music"
                };

                builder.setTitle("Verizon Description");
                builder.setItems(strings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Description clicked
                    }
                });

                dialog = builder.create();
                dialog.show();

            }
        });
        support = root.findViewById(R.id.verizon_support);
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobileNumber = "8663387390";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: " + mobileNumber));
                startActivity(intent);
            }
        });

        return root;
    }
}
