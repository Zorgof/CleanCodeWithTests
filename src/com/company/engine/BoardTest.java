package com.company.engine;

import org.junit.*;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;

    @Before
    //  ustawia parametry testowe
    public void setUp() {
        board = new Board(2);
    }

    /* 2 fory  - pierwszy punkt musi sie rownac 0,0
     skoro sa dwa fory to 2 2 expected 4 etc....*/
    @Test
    public void getPointList() {
        assertEquals(4, board.getPointList().size());
        Point point = board.getPointList().get(0);
        assertEquals(0, point.getX());
        assertEquals(0, point.getY());
    }

    @Test
    // sprawdza czy pobrany rozmiar planszy sie prawidłowy
    public void getBoardSize() {
        assertEquals(2, board.getBoardSize());
    }
}