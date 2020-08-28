package com.julian.wirelessadvocates.models;

import android.util.Log;

import java.util.ArrayList;

public class Carrier {

    public String name;
    public ArrayList<Plan> plans = new ArrayList<>();
    public int monthsAgreement;

    public Carrier(){}
    public Carrier(String name, ArrayList<Plan> plans, int monthsAgreement){
        this.name = name;
        this.plans = plans;
        this.monthsAgreement = monthsAgreement;
    }

    public Plan getPlanByName(String name){
        for(int i = 0; i < this.plans.size(); i++){
            if(plans.get(i).name == name)
                return plans.get(i);
        }
        return null;
    }
}
