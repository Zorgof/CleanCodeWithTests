package com.company.engine;

public enum ShipStatus {

    HIT("X"),
    MISSED("O"),
    UNDISCOVERED("*");


    private final String name;

    ShipStatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
