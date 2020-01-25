package com.company.engine;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Point> pointList = new ArrayList<>();
    private final int boardSize;

    //tworzy siatke
    public Board(int boardSize) {
        this.boardSize = boardSize;
        for (int y = 0; y < boardSize; y++) {
            for (int x = 0; x < boardSize; x++) {
                pointList.add(new Point(x, y));
            }
        }
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public int getBoardSize() {
        return boardSize;
    }
}
