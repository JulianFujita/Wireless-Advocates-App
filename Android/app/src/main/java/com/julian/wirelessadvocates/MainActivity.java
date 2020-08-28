package com.julian.wirelessadvocates;

import android.app.ActionBar;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.Window;

import com.julian.wirelessadvocates.fragments.CalculatorFragment;
import com.julian.wirelessadvocates.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity implements CalculatorFragment.CalculatorBackButton {

    private static final String TAG = "MainActivity";
    FloatingActionButton fab;
    CalculatorFragment calculatorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        fab = findViewById(R.id.fab);

        final FragmentManager fm = getSupportFragmentManager();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.hide();
                calculatorFragment = new CalculatorFragment();
                calculatorFragment.show(getSupportFragmentManager(), "calculator");
            }
        });

    }

    @Override
    public void dismissDialog()
    {
        calculatorFragment.dismiss();
        fab.show();
    }
}