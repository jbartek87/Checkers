package com.kodilla.logic;

import org.junit.Test;

public class BoardTestSuite {
    @Test
    public void testBoard()throws ArrayIndexOutOfBoundsException {

        Board board = new Board();
        board.iniBoard(board);
        try {
            board.move(1, 6, 0, 5);
            board.move(0, 5, 1, 4);
            board.move(1, 4, 2, 4);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You have reached the end of board");
        }

        System.out.println(board);
    }
}
