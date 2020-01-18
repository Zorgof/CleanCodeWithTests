package com.company.engine;

import com.company.engine.scanner.ScannerUtil;
import com.company.engine.ship.Ship;
import com.company.engine.ui.BoardUI;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

class GameEngine {
    public final BoardUI boardUi = new BoardUI();
    public final Board board;
    public final List<Ship> listShips;
    public int shotCounter;

    GameEngine(Board board, List<Ship> listShips) {
        this.board = board;
        this.listShips = listShips;
    }

    void configuration() {
        addShipToBoard();
    }

    private void addShipToBoard() {
        for (int shipId = 0; shipId < listShips.size(); shipId++) {
            int randomNum = getRandomNum(shipId);
            for (int filedId = 0; filedId < listShips.get(shipId).getShortPoints().size(); filedId++) {
                board.getPointList().get(randomNum + filedId).setPointShip(new PointShip(shipId, filedId));
            }
        }
    }

    private int getRandomNum(int shipId) {
        return ThreadLocalRandom
                .current()
                .nextInt(0, getMaxRandomValue(shipId));
    }

    public int getMaxRandomValue(int shipId) {
        return board.getPointList().size() + 1 - listShips.get(shipId).getShortPoints().size();
    }

    public void shotToShip(int x, int y) {
        board.getPointList()
                .stream()
                .filter(point -> point.getX() == x && point.getY() == y).collect(Collectors.toList())
                .get(0)
                .shot();

    }

    void play() {
        System.out.println("Stzelaj podaj x i y");
        do {
            int x = ScannerUtil.getShotFromUser(board.getBoardSize());
            System.out.println("x " + x);
            int y = ScannerUtil.getShotFromUser(board.getBoardSize());
            System.out.println("y " + y);
            checkAndShotPoint(x, y);
        } while (!isAllShipDestroyed());
    }

    public void checkAndShotPoint(int x, int y) {
        if (isPointShoted(x, y)) {
            System.out.println("Punkt by juz ustrzelony");
        } else {
            shotToShip(x, y);
            addToResult(getShotedItem(x, y));
            boardUi.show(board);
            boardUi.showStats(listShips);
        }
        shotCounter++;
        System.out.println("Aby wygrać potrzebowałeś: " + shotCounter);
    }


    public boolean isAllShipDestroyed() {
        return listShips.stream().allMatch(Ship::isDestroyed);
    }

    public boolean isPointShoted(int x, int y) {
        return board.getPointList()
                .stream()
                .filter(point -> point.getX() == x && point.getY() == y)
                .allMatch(Point::isShoted);
    }

    public void addToResult(PointShip shotedItem) {
        Optional.ofNullable(shotedItem)
                .ifPresent(item ->
                        listShips.get(item.getShipId())
                                .getShortPoints()
                                .set(item.getFiledId(), 1));
    }

    public PointShip getShotedItem(int x, int y) {
        return board.getPointList()
                .stream()
                .filter(point -> point.getX() == x && point.getY() == y).collect(Collectors.toList())
                .get(0)
                .getPointShip();
    }

}
