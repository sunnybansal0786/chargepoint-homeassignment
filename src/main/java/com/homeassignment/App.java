package com.homeassignment;

import java.util.Map;

import com.homeassignment.model.Charger;
import com.homeassignment.model.Truck;
import com.homeassignment.scheduler.GreedySchedulerSingle;
import com.homeassignment.scheduler.Scheduler;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {/* 
       Truck[] trucks = {
            new Truck(1, 100, 20), // Truck 1: 100 kWh capacity, 20 kWh currently charged
            new Truck(2, 200, 50), // Truck 2: 200 kWh capacity, 50 kWh currently charged
            new Truck(3, 150, 70), // Truck 3: 150 kWh capacity, 70 kWh currently charged
            new Truck(4, 100, 80), // Truck 4: 100 kWh capacity, 80 kWh currently charged
            new Truck(5, 300, 100) // Truck 5: 300 kWh capacity, 100 kWh currently charged
        };

        Charger[] chargers = {
            new Charger(1, 50),    // Charger 1: 50 kW charging rate
            new Charger(2, 60)     // Charger 2: 60 kW charging rate
        };

        int availableHours = 5;  // Available time to charge trucks

        // Use the GreedyScheduler to schedule the trucks
        Scheduler scheduler = new GreedySchedulerSingle();
        Map<Charger, Truck[]> schedule = scheduler.schedule(trucks, chargers, availableHours);

        // Print the charging schedule
        System.out.println("Charging Schedule:");
        for (Charger charger : schedule.keySet()) {
            System.out.print("Charger " + charger.id + ": ");
            for (Truck truck : schedule.get(charger)) {
                System.out.print("Truck " + truck.id + " ");
            }
            System.out.println();
        }
            */

        Truck[] trucks = {
            new Truck(1, 100, 30),
            new Truck(2, 200, 50)
        };
        Charger[] chargers = {
            new Charger(1, 10),
            new Charger(2, 20)
        };
        Scheduler scheduler = new GreedySchedulerSingle();
        Map<Charger, Truck[]> result = scheduler.schedule(trucks, chargers, 5);

        result.size();

    }
}
