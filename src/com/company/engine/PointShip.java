package com.company.engine;

final class PointShip {

    private final int shipId;
    private final int filedId;

    PointShip(int shipId, int filedId) {
        this.shipId = shipId;
        this.filedId = filedId;
    }

    int getShipId() {
        return shipId;
    }

    int getFiledId() {
        return filedId;
    }

}
