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
public class TMobileFragment extends Fragment {

    private Button website;
    private Button ratePlans;
    private Button militaryPlans;
    private Button coverageMap;
    private Button coverage5G;
    private Button support;
    private Button description;

    public TMobileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_t_mobile, container, false);

        // Initialize buttons here
        website = root.findViewById(R.id.tmobile_website);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.t-mobile.com/"));
                startActivity(browserIntent);
            }
        });
        ratePlans = root.findViewById(R.id.tmobile_plans);
        ratePlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.t-mobile.com/cell-phone-plans"));
                startActivity(browserIntent);
            }
        });
        militaryPlans = root.findViewById(R.id.tmobile_military_plans);
        militaryPlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.t-mobile.com/cell-phone-plans/military-discount-plans"));
                startActivity(browserIntent);
            }
        });
        coverageMap = root.findViewById(R.id.tmobile_coverage_map);
        coverageMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.t-mobile.com/coverage/coverage-map"));
                startActivity(browserIntent);
            }
        });
        coverage5G = root.findViewById(R.id.tmobile_5g_coverage_map);
        coverage5G.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.t-mobile.com/coverage/4g-lte-5g-networks"));
                startActivity(browserIntent);
            }
        });
        description = root.findViewById(R.id.tmobile_description);
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog;
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                String[] strings = {
                        "Activation Fee: Free",
                        "Upgrade Fee: $20.00/Device",
                        "Extra Device Fee: $10.00/Device",
                        "Services: Netflix",
                        "Taxes: Included in plan"
                };

                builder.setTitle("T-Mobile Description");
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
        support = root.findViewById(R.id.tmobile_support);
        support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobileNumber = "8883108369";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: " + mobileNumber));
                startActivity(intent);
            }
        });

        return root;
    }
}
