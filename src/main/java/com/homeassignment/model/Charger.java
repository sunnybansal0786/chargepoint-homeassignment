package com.homeassignment.model;

public class Charger {
    public int id;
    public double rate;

    public Charger(int id, double rate) {
        this.id = id;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Charger " + id;
    }
}