package com.kodilla.ai;

import com.kodilla.logic.Board;
import com.kodilla.logic.FigureColor;
import com.kodilla.logic.Pawn;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.logic.FigureColor.BLACK;
import static com.kodilla.logic.FigureColor.WHITE;

public class AiLogic {
    private List<Move> possibleMoves = new ArrayList<>();
    private List<ScoredMove> scoredMoves = new ArrayList<>();


    public Move getBestMove(Board board, FigureColor whoMoves, int stepsCount) {
        // 1. Zbudować listę wszystkich mozliwych ruchów


        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {

                possibleMovesOfFigure(board, whoMoves, col, row);
            }
        }


        //2. Dla każdego z tych możliwych ruchów obliczam punktacje planszy
        for (Move move : possibleMoves) {
            Board boardTemp = new Board(board);
            boardTemp.move(move.getCol1(), move.getRow1(), move.getRow2(), move.getRow2());
            int score = calculateScore(boardTemp, whoMoves);
            scoredMoves.add(new ScoredMove(move, score));

        }


        //3. Wybieram ruch najkorzystniejszy dla whoMoves

        //4. Robie kopie board(deep copy)

        Board boardTemp = new Board();
        boardTemp = board;

        //5. Wykonuje na skopiowanej planszy ruch wybrany w pkt.3
        //6. Wywołuje rekurencyjnie getBestMove przekazując jej kopie planszy z jednym ruchem zrobionym
        //   oraz zmienionym whoMoves oraz stepsCount zmniejszonym o 1
        //7. Algorytm wykonuje założoną ilość razy (rekomendowane 3), czyli sprawdza czy stepsCount>0
        //8. Wygrywa ten ruch z pierwszego wykonania algorytmu , który w ostatnim wykonaniu algorytmu
        // dał najwyższą punktację sytuacji na planszy
        // Założenie: człowiek wybierze ścieżke dającą mu najwięcej pkt w jednym ruchu
        return null;
    }

    private void possibleMovesOfFigure(Board board, FigureColor whoMoves, int col, int row) {
        if (board.getFigure(col, row).getColor() == whoMoves) {
            int dY = (whoMoves == FigureColor.BLACK) ? 1 : -1;
            possibleMovesToLeftOrRight(board, col, row, dY, col - 1 >= 0, col - 1);
            possibleMovesToLeftOrRight(board, col, row, dY, col + 1 <= 7, col + 1);
            possibleHitsToLeftOrRight(board, whoMoves, col, row, dY, col - 2 >= 0, col - 2, col - 1);
            possibleHitsToLeftOrRight(board, whoMoves, col, row, dY, col + 2 <= 7, col + 2, col + 1);
        }
    }

    private void possibleHitsToLeftOrRight(
            Board board, FigureColor whoMoves, int col, int row, int direction,
            boolean notOutside, int targetCol, int hittedCol) {

        if (notOutside) {
            if (board.getFigure(targetCol, row + 2 * direction).getColor() == FigureColor.NONE &&
                    board.getFigure(hittedCol, row + direction).getColor() == getOppositeColor(whoMoves))
                possibleMoves.add(new Move(col, row, targetCol, row + 2 * direction));
        }
    }

    private FigureColor getOppositeColor(FigureColor whoMoves) {
        return (whoMoves == WHITE) ? BLACK : WHITE;
    }

    private void possibleMovesToLeftOrRight(
            Board board, int col, int row, int direction, boolean notOutside, int targetCol) {

        if (notOutside) {
            if (board.getFigure(targetCol, row + direction).getColor() == FigureColor.NONE)
                possibleMoves.add(new Move(col, row, targetCol, row + direction));
        }
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


        }
        if (whoMoves == FigureColor.BLACK) {
            for (int col = 0; col < 8; col++) {
                for (int row = 0; row < 8; row++) {
                    if (board.getFigure(col, row) instanceof Pawn && board.getFigure(col, row).getColor() == FigureColor.BLACK) {
                        score = score + row-7;
                    }
                }
            }
            score = Math.abs(score);


        }
        System.out.println(whoMoves + " score = " + score);
        return score;
        // 2. jeżeli jest możliwe jakieś bicie to dodaje np. + 15 pkt
        // 3. od wyniku odejmujemy pkt przeciwnika policzone tak samo

    }

}

