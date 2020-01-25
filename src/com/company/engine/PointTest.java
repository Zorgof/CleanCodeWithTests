package com.company.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
        // tworze dwa punkty, 1-nietrafiony, 2 trafiony i sprawdzam czy maja poprawne deskrypcje
    void isShoted() {
        Point point = new Point(0, 0);
        point.setShoted(true);

        Point point2 = new Point(0, 0);
        point2.setShoted(false);

        assertEquals(ShipStatus.MISSED.toString(), point.getDescription());
        assertEquals(ShipStatus.UNDISCOVERED.toString(), point2.getDescription());
    }
}
