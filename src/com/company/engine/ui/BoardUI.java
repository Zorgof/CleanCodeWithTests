package com.company.engine.ui;

import com.company.engine.Board;
import com.company.engine.Point;
import com.company.engine.ship.Ship;

import java.util.List;

public class BoardUI {

    public void showStats(List<Ship> listShips) {
        listShips.forEach(System.out::println);
    }

    public void show(Board board) {
        List<Point> pointList = board.getPointList();

        for (int i = 0; i <= board.getBoardSize() -1; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();

        for (Point point : pointList) {
            if (point.getX() == board.getBoardSize() - 1) {
                System.out.println(" " + point.getDescription() + "  " + point.getY());
            } else {
                System.out.print(" " + point.getDescription() + " ");
            }
        }
    }
}

