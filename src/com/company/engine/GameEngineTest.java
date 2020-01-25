package com.company.engine;

import com.company.engine.ship.Ship;
import com.company.engine.ship.ShipOne;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GameEngineTest {

    private GameEngine gameEngine;
    private Board board;

    @Before
    //ustawia parametry testowe
    public void setup() {
        board = new Board(3);
        List<Ship> shipList = createShips();
        gameEngine = new GameEngine(board, shipList);
    }

    @Test
    //sprawdza czy metoda configuration dodaje ship do board, ktory ma rozmiar 9, Y-ki 0;3;6 element
    public void configuration() {
        gameEngine.configuration();
        assertEquals(9, board.getPointList().size());
        assertEquals(0, board.getPointList().get(0).getY());
        assertEquals(1, board.getPointList().get(3).getY());
        assertEquals(2, board.getPointList().get(6).getY());
    }

    @Test
    // Najpierw trafia, potem sprawdza czy jest trafiony ( jesli isShoted = true than success) (nie wazne czy X czy O)
    public void checkAndShotPoint() {
        gameEngine.checkAndShotPoint(0, 0);
        assertEquals(true, board.getPointList().get(0).isShoted());
    }

    @Test
    // trafia i test sprawdza czy jest trafiony ( jesli isShoted = true than success)
    public void shotToShip() {
        gameEngine.shotToShip(0, 0);
        assertEquals(true, board.getPointList().get(0).isShoted());
    }


    @Test
    //strzelamy i sprawdzamy czy tez sam punkt byl trafiony
    public void isPointShoted() {
        gameEngine.shotToShip(0, 0); // jesli dam takie same inputy to spodziewam sie true jesli nie to false)
        assertEquals(true, gameEngine.isPointShoted(0, 0));
    }

    @Test
    //dodajemy trafiony strzal do listy i sprawdzany czy ta lista zawiera dodany elemnt
    public void addToResult() {
        gameEngine.shotToShip(0, 0);
        PointShip pointShip = gameEngine.getShotedItem(0, 0);
        gameEngine.addToResult(pointShip);
        assertEquals(Integer.valueOf(0), gameEngine.listShips.get(0).getShortPoints().get(0));
    }

    @Test
    //sprawdzany czy wszystkie statki sa trafione - poprawny test powinnien zwrocic falsz.
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