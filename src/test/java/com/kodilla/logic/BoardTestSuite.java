package com.kodilla.logic;

import org.junit.Test;

public class BoardTestSuite {
    @Test
    public void testBoard()throws ArrayIndexOutOfBoundsException {

        Board board = new Board();
        board.initBoard(board);
        try {
            board.move(3, 6, 4, 5);
            board.move(6, 3, 5, 4);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You have reached the end of board");
        }

        System.out.println(board);
    }
}
