package com.homeassignment.model;

public class Truck {
    public int id;
    public double batteryCapacity;
    public double currentCharge;

    public Truck(int id, double batteryCapacity, double currentCharge) {
        this.id = id;
        this.batteryCapacity = batteryCapacity;
        this.currentCharge = currentCharge;
    }

    public double remainingCharge() {
        return batteryCapacity - currentCharge;
    }
    
    @Override
    public String toString() {
        return "Truck " + id;
    }
}
