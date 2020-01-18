package com.company.engine.ship;

import java.util.ArrayList;
import java.util.List;

public abstract class Ship {

    private final int length;
    private final List<Integer> shortPoints = new ArrayList<>();
    private final String description;

    Ship(String description, int length) {
        this.description = description;
        this.length = length;

        for (int i = 0; i < length; i++) {
            shortPoints.add(0);
        }
    }

    public List<Integer> getShortPoints() {
        return shortPoints;
    }

    public boolean isDestroyed(){
        return shortPoints.stream().allMatch(item -> item.equals(1));
    }

    @Override
    public String toString() {
        return description +"{" +
                ", shortPoints=" + shortPoints +
                ", length=" + length +
                '}';
    }

    public String getDescription() {
        return description;
    }
}
