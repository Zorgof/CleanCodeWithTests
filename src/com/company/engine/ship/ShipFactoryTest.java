package com.company.engine.ship;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ShipFactoryTest {

    @Test //sprawdza czy wyrzuone exception jest tym przadanym
    public void generateShipThrowException() {
        ShipFactory shipFactory =  new ShipFactory();
        try {
            shipFactory.generateShip(3);
        }catch (IllegalArgumentException ex){
            assertEquals("Unknown number", ex.getMessage());
        }
    }

    @Test // tworze poszczegolne statki sprawdzam czy stworzony obiekt nei ejst NUllem
    public void generateShip() {
        ShipFactory shipFactory =  new ShipFactory();
        Ship ship1 = shipFactory.generateShip(0);
        Ship ship2 = shipFactory.generateShip(1);
        Ship ship3 = shipFactory.generateShip(2);
        assertNotEquals(null, ship1);
        assertNotEquals(null, ship2);
        assertNotEquals(null, ship3);
    }
}