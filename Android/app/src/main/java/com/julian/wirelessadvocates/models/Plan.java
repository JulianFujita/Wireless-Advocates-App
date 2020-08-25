package com.julian.wirelessadvocates.models;

import java.util.HashMap;

public class Plan {
    public String name;
    public HashMap<Integer, Float> priceMap = new HashMap<>();

    public Plan(String name, HashMap<Integer, Float> priceMap){
        this.name = name;
        this.priceMap = priceMap;
    }
}
