package com.julian.wirelessadvocates.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.julian.wirelessadvocates.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttFragment extends Fragment {

    private Button website;
    private Button ratePlans;
    private Button militaryPlans;
    private Button coverageMap;
    private Button coverage5G;
    private Button support;
    private Button description;

    public AttFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_att, container, false);

        // Initialize buttons here
        website = root.findViewById(R.id.att_website);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.att.com/"));
                startActivity(browserIntent);
            }
        });
        ratePlans = root.findViewById(R.id.att_plans);
        ratePlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.att.com/plans/wireless"));
                startActivity(browserIntent);
            }
        });
        militaryPlans = root.findViewById(R.id.att_military_plans);
        militaryPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.att.com/offers/discount-program/military-discount"));
                startActivity(browserIntent);
            }
        });
        coverageMap = root.findViewById(R.id.att_coverage_map);
        coverageMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.att.com/maps/wireless-coverage.html"));
                startActivity(browserIntent);
            }
        });
        coverage5G = root.findViewById(R.id.att_5g_coverage_map);
        coverage5G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.att.com/5g/coverage-map"));
                startActivity(browserIntent);
            }
        });
        description = root.findViewById(R.id.att_description);
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog;
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                String[] strings = {
                        "Activation Fee: $30.00/Device (Free if BYOD)",
                        "Upgrade Fee: $45.00/Device ($30 if existing customer)",
                        "Extra Device Fee: $10.00/Device",
                        "Services: HBO Max"
                };

                builder.setTitle("AT&T Description");
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
        support = root.findViewById(R.id.att_support);
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobileNumber = "8883552518";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: " + mobileNumber));
                startActivity(intent);
            }
        });

        return root;
    }
}
