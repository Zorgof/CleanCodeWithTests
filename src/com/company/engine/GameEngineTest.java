package com.company.engine;

import com.company.engine.ship.Ship;
import com.company.engine.ship.ShipOne;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameEngineTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private GameEngine gameEngine;
    private Board board;
    private List<Ship> shipList;

    @Before
    public void setup() {
        board = new Board(3);
        shipList = createShips();
        gameEngine = new GameEngine(board, shipList);
    }

    @Test
    public void configuration() {
        gameEngine.configuration();
        assertEquals(9, board.getPointList().size());
        assertEquals(0, board.getPointList().get(0).getY());
        assertEquals(1, board.getPointList().get(3).getY());
        assertEquals(2, board.getPointList().get(6).getY());
    }

    @Test
    public void checkAndShotPoint() {
        gameEngine.checkAndShotPoint(0,0); // Najpierw trafia, potem sprawdza czy jest trafiony ( jesli isShoted = true than success) (nie wazne czy X czy O)
        assertEquals(true, board.getPointList().get(0).isShoted());
    }

    @Test
    public void shotToShip() {
        gameEngine.shotToShip(0, 0);
        assertEquals(true, board.getPointList().get(0).isShoted());
    }


    @Test
    public void isPointShoted() {
        gameEngine.shotToShip(0, 0); // jesli dam takie same inputy to spiodziewam sie true jesli nei to false)
        assertEquals(true, gameEngine.isPointShoted(0, 0));
    }

    @Test
    public void addToResult() {
        gameEngine.shotToShip(0, 0);
        PointShip pointShip = gameEngine.getShotedItem(0, 0);
        gameEngine.addToResult(pointShip);
        assertEquals(Integer.valueOf(0), gameEngine.listShips.get(0).getShortPoints().get(0));
    }




    @Test
    public void isAllShipDestroyed() {
        assertEquals(false, gameEngine.isAllShipDestroyed());
    }
    private List<Ship> createShips() {
        List<Ship> ships = new ArrayList<>();
        Ship shipOne = new ShipOne();
        ships.add(shipOne); // dodanie tylko jednego statku
        return ships;
    }

}