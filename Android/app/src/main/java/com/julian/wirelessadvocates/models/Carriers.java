package com.julian.wirelessadvocates.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Carriers {

    public static Carrier VERIZON;
    public static Carrier ATT;
    public static Carrier T_MOBILE;

    public Carriers(){

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


        ArrayList<Plan> attPlans = new ArrayList<>();   // AT&T

        HashMap<Integer, Float> attUnlimitedElite = new HashMap<>();
        attUnlimitedElite.put(1, 85f);
        attUnlimitedElite.put(2, 75f);
        attUnlimitedElite.put(3, 60f);
        attUnlimitedElite.put(4, 50f);
        attPlans.add(new Plan("Unlimited Elite", attUnlimitedElite));

        HashMap<Integer, Float> attUnlimitedExtra = new HashMap<>();
        attUnlimitedExtra.put(1, 75f);
        attUnlimitedExtra.put(2, 65f);
        attUnlimitedExtra.put(3, 50f);
        attUnlimitedExtra.put(4, 40f);
        attPlans.add(new Plan("Unlimited Extra", attUnlimitedExtra));

        HashMap<Integer, Float> attUnlimitedStarter = new HashMap<>();
        attUnlimitedStarter.put(1, 65f);
        attUnlimitedStarter.put(2, 60f);
        attUnlimitedStarter.put(3, 45f);
        attUnlimitedStarter.put(4, 35f);
        attPlans.add(new Plan("Unlimited Starter", attUnlimitedStarter));

        HashMap<Integer, Float> attMobileSharePlus9GB = new HashMap<>();
        attMobileSharePlus9GB.put(1, 60f);
        attMobileSharePlus9GB.put(2, 50f);
        attMobileSharePlus9GB.put(3, 40f);
        attMobileSharePlus9GB.put(4, 35f);
        attPlans.add(new Plan("Mobile Share Plus 9GB", attMobileSharePlus9GB));

        HashMap<Integer, Float> attMobileSharePlus3GB = new HashMap<>();
        attMobileSharePlus3GB.put(1, 50f);
        attMobileSharePlus3GB.put(2, 40f);
        attMobileSharePlus3GB.put(3, 34f);
        attMobileSharePlus3GB.put(4, 30f);
        attPlans.add(new Plan("Mobile Share Plus 3GB", attMobileSharePlus3GB));

        HashMap<Integer, Float> attMilitaryUnlimitedStarter = new HashMap<>();
        attMilitaryUnlimitedStarter.put(1, 48.75f);
        attMilitaryUnlimitedStarter.put(2, 45f);
        attMilitaryUnlimitedStarter.put(3, 33.75f);
        attMilitaryUnlimitedStarter.put(4, 26.25f);
        attPlans.add(new Plan("Military Unlimited Starter", attMilitaryUnlimitedStarter));

        HashMap<Integer, Float> attMilitaryUnlimitedExtra = new HashMap<>();
        attMilitaryUnlimitedExtra.put(1, 56.25f);
        attMilitaryUnlimitedExtra.put(2, 48.75f);
        attMilitaryUnlimitedExtra.put(3, 37.50f);
        attMilitaryUnlimitedExtra.put(4, 30f);
        attPlans.add(new Plan("Military Unlimited Extra", attMilitaryUnlimitedExtra));

        HashMap<Integer, Float> attMilitaryUnlimitedElite = new HashMap<>();
        attMilitaryUnlimitedElite.put(1, 63.75f);
        attMilitaryUnlimitedElite.put(2, 56.25f);
        attMilitaryUnlimitedElite.put(3, 45f);
        attMilitaryUnlimitedElite.put(4, 37.5f);
        attPlans.add(new Plan("Military Unlimited Elite", attMilitaryUnlimitedElite));

        ATT = new Carrier("AT&T", attPlans, 30);


        ArrayList<Plan> tmobilePlans = new ArrayList<>();   // T-Mobile

        HashMap<Integer, Float> tmobileEssentials = new HashMap<>();
        tmobileEssentials.put(1, 60f);
        tmobileEssentials.put(2, 45f);
        tmobileEssentials.put(3, 35f);
        tmobileEssentials.put(4, 30f);
        tmobileEssentials.put(5, 27f);
        tmobileEssentials.put(6, 25f);
        tmobilePlans.add(new Plan("Essentials", tmobileEssentials));

        HashMap<Integer, Float> tmobileMagenta = new HashMap<>();
        tmobileMagenta.put(1, 70f);
        tmobileMagenta.put(2, 60f);
        tmobileMagenta.put(3, 40f);
        tmobileMagenta.put(4, 35f);
        tmobileMagenta.put(5, 32f);
        tmobileMagenta.put(6, 30f);
        tmobileMagenta.put(7, 29f);
        tmobileMagenta.put(8, 28f);
        tmobilePlans.add(new Plan("Magenta", tmobileMagenta));

        HashMap<Integer, Float> tmobileMagentaPlus = new HashMap<>();
        tmobileMagentaPlus.put(1, 85f);
        tmobileMagentaPlus.put(2, 70f);
        tmobileMagentaPlus.put(3, 47f);
        tmobileMagentaPlus.put(4, 43f);
        tmobileMagentaPlus.put(5, 40f);
        tmobileMagentaPlus.put(6, 38f);
        tmobileMagentaPlus.put(7, 37f);
        tmobileMagentaPlus.put(8, 36f);
        tmobilePlans.add(new Plan("Magenta Plus", tmobileMagentaPlus));

        HashMap<Integer, Float> tmobileMilitaryMagenta = new HashMap<>();
        tmobileMilitaryMagenta.put(1, 55f);
        tmobileMilitaryMagenta.put(2, 40f);
        tmobileMilitaryMagenta.put(3, 30f);
        tmobileMilitaryMagenta.put(4, 25f);
        tmobileMilitaryMagenta.put(5, 22f);
        tmobilePlans.add(new Plan("Military Magenta", tmobileMilitaryMagenta));

        HashMap<Integer, Float> tmobileMilitaryMagentaPlus = new HashMap<>();
        tmobileMilitaryMagentaPlus.put(2, 50f);
        tmobileMilitaryMagentaPlus.put(3, 40f);
        tmobileMilitaryMagentaPlus.put(4, 35f);
        tmobileMilitaryMagentaPlus.put(5, 32f);
        tmobilePlans.add(new Plan("Military Magenta Plus", tmobileMilitaryMagentaPlus));

        T_MOBILE = new Carrier("T-Mobile", tmobilePlans, 24);

    }
}
