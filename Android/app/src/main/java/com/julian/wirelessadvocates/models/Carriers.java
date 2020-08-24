package com.julian.wirelessadvocates.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Carriers {

    public static Carrier VERIZON;
    public static Carrier ATT;
    public static Carrier T_MOBILE;

    public Carriers(){
        // TODO create carriers and plans here

        ArrayList<Plan> verizonPlans = new ArrayList<>();   // VERIZON

        HashMap<Integer, Float> verizonStartUnlimited = new HashMap<>();    // Start Unlimited
        verizonStartUnlimited.put(1, 70f);
        verizonStartUnlimited.put(2, 60f);
        verizonStartUnlimited.put(3, 45f);
        verizonStartUnlimited.put(4, 35f);
        verizonStartUnlimited.put(5, 30f);
        verizonPlans.add(new Plan("Start Unlimited", verizonStartUnlimited));

        HashMap<Integer, Float> verizonPlayMoreUnlimited = new HashMap<>();    // Play More Unlimited
        verizonPlayMoreUnlimited.put(1, 80f);
        verizonPlayMoreUnlimited.put(2, 70f);
        verizonPlayMoreUnlimited.put(3, 55f);
        verizonPlayMoreUnlimited.put(4, 45f);
        verizonPlayMoreUnlimited.put(5, 40f);
        verizonPlans.add(new Plan("Play More Unlimited", verizonPlayMoreUnlimited));

        HashMap<Integer, Float> verizonDoMoreUnlimited = new HashMap<>();    // Do More Unlimited
        verizonDoMoreUnlimited.put(1, 80f);
        verizonDoMoreUnlimited.put(2, 70f);
        verizonDoMoreUnlimited.put(3, 55f);
        verizonDoMoreUnlimited.put(4, 45f);
        verizonDoMoreUnlimited.put(5, 40f);
        verizonPlans.add(new Plan("Do More Unlimited", verizonDoMoreUnlimited));

        HashMap<Integer, Float> verizonGetMoreUnlimited = new HashMap<>();    // Get More Unlimited
        verizonGetMoreUnlimited.put(1, 90f);
        verizonGetMoreUnlimited.put(2, 80f);
        verizonGetMoreUnlimited.put(3, 65f);
        verizonGetMoreUnlimited.put(4, 55f);
        verizonGetMoreUnlimited.put(5, 50f);
        verizonPlans.add(new Plan("Get More Unlimited", verizonGetMoreUnlimited));

        HashMap<Integer, Float> verizonJustKids = new HashMap<>();    // Just Kids
        verizonJustKids.put(2, 50f);
        verizonJustKids.put(3, 40f);
        verizonJustKids.put(4, 35f);
        verizonJustKids.put(5, 25f);
        verizonPlans.add(new Plan("Just Kids", verizonJustKids));

        VERIZON = new Carrier("Verizon", verizonPlans, 24);
    }
}
