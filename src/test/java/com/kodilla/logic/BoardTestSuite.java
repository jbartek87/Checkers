package com.kodilla.logic;

import org.junit.Test;

public class BoardTestSuite {
    @Test
    public void testBoard() {

        Board board = new Board();
        board.setFigure(1,1, new Pawn(FigureColor.WHITE));
        board.setFigure(2,2, new Pawn(FigureColor.BLACK));
        System.out.println(board);
    }
}
