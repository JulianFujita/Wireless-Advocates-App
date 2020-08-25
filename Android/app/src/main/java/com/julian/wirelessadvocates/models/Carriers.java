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

        HashMap<Integer, Float> verizonMilitaryStartUnlimited = new HashMap<>();    // Military Start Unlimited
        verizonMilitaryStartUnlimited.put(1, 60f);
        verizonMilitaryStartUnlimited.put(2, 47.50f);
        verizonMilitaryStartUnlimited.put(3, 36.66f);
        verizonMilitaryStartUnlimited.put(4, 30f);
        verizonPlans.add(new Plan("Military Start Unlimited", verizonMilitaryStartUnlimited));

        HashMap<Integer, Float> verizonMilitaryPlayMoreUnlimited = new HashMap<>(); // Military Play More Unlimited
        verizonMilitaryPlayMoreUnlimited.put(1, 70f);
        verizonMilitaryPlayMoreUnlimited.put(2, 57.50f);
        verizonMilitaryPlayMoreUnlimited.put(3, 46.66f);
        verizonMilitaryPlayMoreUnlimited.put(4, 40f);
        verizonPlans.add(new Plan("Military Play More Unlimited", verizonMilitaryPlayMoreUnlimited));

        HashMap<Integer, Float> verizonMilitaryDoMoreUnlimited = new HashMap<>();   // Military Do More Unlimited
        verizonMilitaryDoMoreUnlimited.put(1, 70f);
        verizonMilitaryDoMoreUnlimited.put(2, 57.50f);
        verizonMilitaryDoMoreUnlimited.put(3, 46.66f);
        verizonMilitaryDoMoreUnlimited.put(4, 40f);
        verizonPlans.add(new Plan("Military Do More Unlimited", verizonMilitaryDoMoreUnlimited));

        HashMap<Integer, Float> verizonMilitaryGetMoreUnlimited = new HashMap<>();  // Military Get More Unlimited
        verizonMilitaryGetMoreUnlimited.put(1, 80f);
        verizonMilitaryGetMoreUnlimited.put(2, 67.50f);
        verizonMilitaryGetMoreUnlimited.put(3, 56.66f);
        verizonMilitaryGetMoreUnlimited.put(4, 50f);
        verizonPlans.add(new Plan("Military Get More Unlimited", verizonMilitaryGetMoreUnlimited));

        VERIZON = new Carrier("Verizon", verizonPlans, 24);

    }
}
