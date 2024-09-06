package com.homeassignment.scheduler;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.homeassignment.model.Charger;
import com.homeassignment.model.Truck;

import java.util.ArrayList;

public class GreedySchedulerSingle implements Scheduler {

    @Override
    public Map<Charger, Truck[]> schedule(Truck[] trucks, Charger[] chargers, int availableHours) {
        // Calculate the total energy capacity for each charger
        Map<Charger, Double> chargerEnergyCapacity = new HashMap<>();
        for (Charger charger : chargers) {
            chargerEnergyCapacity.put(charger, charger.rate * availableHours);
        }

        // Sort trucks by the amount of charge they need (descending order)
        Arrays.sort(trucks, (t1, t2) -> Double.compare(t2.remainingCharge(), t1.remainingCharge()));

        // Sort chargers by their power (descending order)
        Arrays.sort(chargers, (c1, c2) -> Double.compare(c2.rate, c1.rate));

        // Initialize map to assign trucks to chargers
        Map<Charger, ArrayList<Truck>> chargerAssignments = new HashMap<>();
        for (Charger charger : chargers) {
            chargerAssignments.put(charger, new ArrayList<>());
        }

        // Allocate energy capacity
        Map<Charger, Double> remainingEnergyCapacity = new HashMap<>(chargerEnergyCapacity);

        // Assign trucks to chargers
        for (Truck truck : trucks) {
            double requiredEnergy = truck.remainingCharge();
            boolean assigned = false;

            // Try to assign the truck to the charger with sufficient remaining capacity
            for (Charger charger : chargers) {
                double availableEnergy = remainingEnergyCapacity.get(charger);
                if (requiredEnergy <= availableEnergy) {
                    // If charger has enough capacity, assign truck and update remaining capacity
                    chargerAssignments.get(charger).add(truck);
                    remainingEnergyCapacity.put(charger, availableEnergy - requiredEnergy);
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                // If a truck can't be fully charged, report it
                System.out.println("Truck " + truck.id + " cannot be fully charged with the available energy capacity.");
            }
        }

        // Convert ArrayList<Truck> to Truck[] for the return type
        Map<Charger, Truck[]> result = new HashMap<>();
        for (Map.Entry<Charger, ArrayList<Truck>> entry : chargerAssignments.entrySet()) {
            Charger charger = entry.getKey();
            ArrayList<Truck> trucksList = entry.getValue();
            result.put(charger, trucksList.toArray(new Truck[0])); // Convert to Truck[]
        }

        return result;
    }
}