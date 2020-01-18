package com.company.engine;

public class Point {

    private final int x;
    private final int y;
    private PointShip pointShip = null;
    private boolean isShoted = false;


    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    PointShip getPointShip() {
        return pointShip;
    }

    void setPointShip(PointShip pointShip) {
        this.pointShip = pointShip;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    boolean isShoted() {
        return isShoted;
    }

    public String getDescription() {
        return generateDescription();
    }

    private String generateDescription() {
        return isShoted ? pointShip == null ? ShipStatus.MISSED.toString() : ShipStatus.HIT.toString()
                : ShipStatus.UNDISCOVERED.toString();
    }

    void shot(){
        isShoted = true;
    }

    public void setShoted(boolean shoted) {
        isShoted = shoted;
    }
}
