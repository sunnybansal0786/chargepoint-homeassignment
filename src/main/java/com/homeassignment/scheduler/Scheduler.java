package com.homeassignment.scheduler;

import java.util.Map;

import com.homeassignment.model.Charger;
import com.homeassignment.model.Truck;

public interface Scheduler {
    Map<Charger, Truck[]> schedule(Truck[] trucks, Charger[] chargers, int availableHours);
}
