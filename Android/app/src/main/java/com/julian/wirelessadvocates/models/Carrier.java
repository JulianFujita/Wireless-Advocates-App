package com.julian.wirelessadvocates.models;

import java.util.ArrayList;

public class Carrier {

    public String name;
    public ArrayList<Plan> plans = new ArrayList<>();
    public int monthsAgreement;

    public Carrier(String name, ArrayList<Plan> plans, int monthsAgreement){
        this.name = name;
        this.plans = plans;
        this.monthsAgreement = monthsAgreement;
    }

}
