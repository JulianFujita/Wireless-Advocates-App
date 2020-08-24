package com.julian.wirelessadvocates.models;

import java.util.ArrayList;

public class Carrier {

    private String name;
    private ArrayList<Plan> plans = new ArrayList<>();
    private int monthsAgreement;

    public Carrier(String name, ArrayList<Plan> plans, int monthsAgreement){
        this.name = name;
        this.plans = plans;
        this.monthsAgreement = monthsAgreement;
    }

}
