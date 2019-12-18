package com.kodilla.logic;

import com.kodilla.ai.AiLogic;
import org.junit.Test;

public class BoardTestSuite {
//    @Test
////    public void testBoard()throws ArrayIndexOutOfBoundsException {
////
////        Board board = new Board();
////        board.initBoard(board);
////        try {
////            board.move(3, 6, 4, 5);
////            board.move(6, 3, 5, 4);
////
////        }catch (ArrayIndexOutOfBoundsException e){
////            System.out.println("You have reached the end of board");
////        }
////
////        System.out.println(board);
////    }
    @Test
    public void logicTest(){
        Board board = new Board();
        AiLogic logic = new AiLogic();
        board.initBoard();
//        board.move(7,5,6, 4);
        board.move(4,2,5,3);  // biały zaczyna
        board.move(7,5,6, 4);
//        board.move(6,6,7, 5);
//        logic.getBestMove(board,FigureColor.BLACK,3);
        logic.calculateScore(board,FigureColor.BLACK);

    }
}
