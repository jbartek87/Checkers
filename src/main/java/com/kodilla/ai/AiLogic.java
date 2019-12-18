package com.kodilla.ai;

import com.kodilla.logic.Board;
import com.kodilla.logic.FigureColor;
import com.kodilla.logic.Pawn;

import java.util.ArrayList;

public class AiLogic {
    ArrayList<Move> possibleMovesWhite = new ArrayList<>();
    ArrayList<Move> possibleMovesBlack = new ArrayList<>();
    ArrayList<Move> possibleHitMoves = new ArrayList<>();
    public Move getBestMove(Board board, FigureColor whoMoves, int stepsCount) {
        // 1. Zbudować listę wszystkich mozliwych ruchów

        Move makeMove = new Move(0, 0, 0, 0);

        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {

                // SPRAWDZANIE DLA CZARNYCH

                if (board.isSimpleMoveValid(col, row, col + 1, row + 1)) {
                    possibleMovesBlack.add(new Move(col, row, col + 1, row + 1));
//                    System.out.println("simple move added");
                }
                if (board.isSimpleMoveValid(col, row, col - 1, row + 1)) {
                    possibleMovesBlack.add(new Move(col, row, col - 1, row + 1));
//                    System.out.println("simple move added");
//                }
//                if (board.isHitMoveValid(col, row, col + 1, row - 1)) {
//                    possibleHitMoves.add(new Move(col, row, col + 1, row + 1));
//                    System.out.println("hit move added");
                }
//                if (board.isHitMoveValid(col, row, col - 1, row - 1)) {
//                    possibleHitMoves.add(new Move(col, row, col - 1, row + 1));
////                    System.out.println("hit move added");
//                }

                // SPRAWDZANIE DLA BIALYCH
                if (board.isSimpleMoveValid(col, row, col + 1, row - 1)) {
                    possibleMovesWhite.add(new Move(col, row, col + 1, row - 1));
                }
                if (board.isSimpleMoveValid(col, row, col - 1, row - 1)) {
                    possibleMovesWhite.add(new Move(col, row, col - 1, row - 1));
                }
                if (board.isHitMoveValid(col, row, col + 1, row - 1)) {
                    possibleHitMoves.add(new Move(col, row, col + 1, row - 1));
                    System.out.println("hit move added");
                }
                if (board.isHitMoveValid(col, row, col - 1, row - 1)) {
                    possibleHitMoves.add(new Move(col, row, col - 1, row - 1));
                    System.out.println("hit move added");
                }
            }
        }
        System.out.println(possibleHitMoves.size());
        //2. Dla każdego z tych możliwych ruchów obliczam punktacje planszy




        //3. Wybieram ruch najkorzystniejszy dla whoMoves
        //4. Robie kopie board(deep copy)
        //5. Wykonuje na skopiowanej planszy ruch wybrany w pkt.3
        //6. Wywołuje rekurencyjnie getBestMove przekazując jej kopie planszy z jednym ruchem zrobionym
        //   oraz zmienionym whoMoves oraz stepsCount zmniejszonym o 1
        //7. Algorytm wykonuje założoną ilość razy (rekomendowane 3), czyli sprawdza czy stepsCount>0
        //8. Wygrywa ten ruch z pierwszego wykonania algorytmu , który w ostatnim wykonaniu algorytmu
        // dał najwyższą punktację sytuacji na planszy
        // Założenie: człowiek wybierze ścieżke dającą mu najwięcej pkt w jednym ruchu
        return null;
    }

    // 1. sumuje dla każdej figury koloru whoMoves na planszy jej odległość od krawędzi bazowej
    public int calculateScore(Board board, FigureColor whoMoves) {
        int score = 0;
        if (whoMoves == FigureColor.WHITE) {
            for (int col = 0; col < 8; col++) {
                for (int row = 0; row < 8; row++) {
                    if (board.getFigure(col, row) instanceof Pawn && board.getFigure(col, row).getColor() == FigureColor.WHITE) {
                        score = score + row;
                    }
                }
            }
            System.out.println(score);


        }

        if (whoMoves == FigureColor.BLACK) {
            for (int col = 0; col < 8; col++) {
                for (int row = 0; row < 8; row++) {
                    if (board.getFigure(col, row) instanceof Pawn && board.getFigure(col, row).getColor() == FigureColor.BLACK) {
                        score = score + row - 7;
                    }
                }
            }
            score = Math.abs(score);
            for(int i=0; i<possibleMovesBlack.size();i++){
                if(board.isHitMoveValid(possibleMovesBlack.get(i).getCol1(),possibleMovesBlack.get(i).getRow1(),possibleMovesBlack.get(i).getCol2(),possibleMovesBlack.get(i).getRow2())){
                    score = score + 15;
                }
            }

        }
        // 2. jeżeli jest możliwe jakieś bicie to dodaje np. + 15 pkt
        // 3. od wyniku odejmujemy pkt przeciwnika policzone tak samo
        System.out.println(score);
        return score;
    }

    }

