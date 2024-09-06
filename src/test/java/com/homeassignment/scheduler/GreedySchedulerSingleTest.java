package com.homeassignment.scheduler;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.homeassignment.model.Charger;
import com.homeassignment.model.Truck;

public class GreedySchedulerSingleTest {

    private void assertSchedule(Map<Charger, Truck[]> actualSchedule, Map<Charger, Truck[]> expectedSchedule) {
        assertEquals("The number of chargers should match.", expectedSchedule.size(), actualSchedule.size());

        for (Map.Entry<Charger, Truck[]> entry : expectedSchedule.entrySet()) {
            Charger charger = entry.getKey();
            Truck[] expectedTrucks = entry.getValue();

            Truck[] actualTrucks = actualSchedule.get(charger);
            assertNotNull("Trucks for charger " + charger.id + " should not be null.", actualTrucks);

            assertArrayEquals("Trucks for charger " + charger.id + " do not match.", expectedTrucks, actualTrucks);
        }
    }

    @Test
    public void testBasicFunctionality() {
        // Setup
        Truck[] trucks = {
            new Truck(1, 100, 50),
            new Truck(2, 150, 75)
        };
        Charger[] chargers = {
            new Charger(1, 10),
            new Charger(2, 20)
        };
        Scheduler scheduler = new GreedySchedulerSingle();
        Map<Charger, Truck[]> result = scheduler.schedule(trucks, chargers, 5);

        // Expected results
        Map<Charger, Truck[]> expectedSchedule = new HashMap<>();
        expectedSchedule.put(chargers[1], new Truck[]{trucks[1]});
        expectedSchedule.put(chargers[0], new Truck[]{trucks[0]});

        // Validate
        assertSchedule(result, expectedSchedule);
    }

    @Test
    public void testNoTrucksCanBeFullyCharged() {
        // Setup
        Truck[] trucks = {
            new Truck(1, 200, 50)
        };
        Charger[] chargers = {
            new Charger(1, 5)
        };
        Scheduler scheduler = new GreedySchedulerSingle();
        Map<Charger, Truck[]> result = scheduler.schedule(trucks, chargers, 10);

        // Expected results
        Map<Charger, Truck[]> expectedSchedule = new HashMap<>();
        expectedSchedule.put(chargers[0], new Truck[]{});

        // Validate
        assertSchedule(result, expectedSchedule);
    }

    @Test
    public void testMultipleChargersWithDifferentPowers() {
        // Setup
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

        // Expected results
        Map<Charger, Truck[]> expectedSchedule = new HashMap<>();
        expectedSchedule.put(chargers[1], new Truck[]{});
        expectedSchedule.put(chargers[0], new Truck[]{trucks[1]});
        

        // Validate
        assertSchedule(result, expectedSchedule);
    }

    @Test
    public void testChargersWithInsufficientTime() {
        // Setup
        Truck[] trucks = {
            new Truck(1, 100, 20),
            new Truck(2, 150, 30)
        };
        Charger[] chargers = {
            new Charger(1, 10),
            new Charger(2, 10)
        };
        Scheduler scheduler = new GreedySchedulerSingle();
        Map<Charger, Truck[]> result = scheduler.schedule(trucks, chargers, 2);

        // Expected results
        Map<Charger, Truck[]> expectedSchedule = new HashMap<>();
        expectedSchedule.put(chargers[0], new Truck[]{});
        expectedSchedule.put(chargers[1], new Truck[]{});

        // Validate
        assertSchedule(result, expectedSchedule);
    }
}