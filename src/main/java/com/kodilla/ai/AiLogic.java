package com.kodilla.ai;

import com.kodilla.logic.Board;
import com.kodilla.logic.FigureColor;
import com.kodilla.logic.Pawn;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.logic.FigureColor.BLACK;
import static com.kodilla.logic.FigureColor.WHITE;

public class AiLogic {
    public List<Move> possibleMoves = new ArrayList<>();
    public List<ScoredMove> scoredMoves = new ArrayList<>();
    Move makeMove;


    public Move getBestMove(Board board, FigureColor whoMoves, int stepsCount) {
        // 1. Zbudować listę wszystkich mozliwych ruchów

        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                possibleMovesOfFigure(board, whoMoves, col, row);
            }
        }

        //2. Dla każdego z tych możliwych ruchów obliczam punktacje planszy
        for (Move move : possibleMoves) {
            int score = 0;
            Board boardTemp = new Board(board);
            if (boardTemp.isHitMoveValid(move.getCol1(), move.getRow1(), move.getCol2(), move.getRow2())) {
                score = score + 15;
            }
            boardTemp.move(move.getCol1(), move.getRow1(), move.getCol2(), move.getRow2());

            score = score + calculateScore(boardTemp, whoMoves);
            scoredMoves.add(new ScoredMove(move, score));
        }


        //3. Wybieram ruch najkorzystniejszy dla whoMoves
        for (ScoredMove scoredMove : scoredMoves) {
            int tempScore = 0;
            if (scoredMove.getScore() >= tempScore) {
                makeMove = scoredMove.getMove();
            }
        }
        //4. Robie kopie board(deep copy)

//        Board boardCopy = new Board();
//        boardCopy.initBoard();


        //5. Wykonuje na skopiowanej planszy ruch wybrany w pkt.3

        board.move(makeMove.getCol1(), makeMove.getRow1(), makeMove.getCol2(), makeMove.getRow2());
        System.out.println("Move from col: " + makeMove.getCol1()+ ", and row: " + makeMove.getRow1() + " to col: "
        + makeMove.getCol2() + ", and row:" + makeMove.getRow2());

        possibleMoves.clear();

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
            int direction = (whoMoves == BLACK) ? -1 : 1;
            possibleMovesToLeftOrRight(board, col, row, direction, col - 1 >= 0, col - 1);
            possibleMovesToLeftOrRight(board, col, row, direction, col + 1 <= 7, col + 1);
            possibleHitsToLeftOrRight(board, whoMoves, col, row, direction, col - 2 >= 0, col - 2, col - 1);
            possibleHitsToLeftOrRight(board, whoMoves, col, row, direction, col + 2 <= 7, col + 2, col + 1);
        }
    }

    private boolean possibleHitsToLeftOrRight(
            Board board, FigureColor whoMoves, int col, int row, int direction,
            boolean notOutside, int targetCol, int hittedCol) {

        if (notOutside) {
            if (board.getFigure(targetCol, row + 2 * direction).getColor() == FigureColor.NONE &&
                    board.getFigure(hittedCol, row + direction).getColor() == getOppositeColor(whoMoves))
                possibleMoves.add(new Move(col, row, targetCol, row + 2 * direction));
            return true;
        }
        return false;
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
        int direction = (whoMoves == BLACK) ? -1 : 1;
        if (whoMoves == WHITE) {
            for (int col = 0; col < 8; col++) {
                for (int row = 0; row < 8; row++) {
                    if (board.getFigure(col, row) instanceof Pawn && board.getFigure(col, row).getColor() == WHITE) {
                        score = score + row + 1;
                        if (col == 0 || col == 7) {
                            score = score + 5;
                        }

                    }
                }
                    }
        } else if (whoMoves == BLACK) {
            for (int col = 0; col < 8; col++) {
                for (int row = 0; row < 8; row++) {
                    if (board.getFigure(col, row) instanceof Pawn && board.getFigure(col, row).getColor() == BLACK) {
                        score = score + row-8;
                        if (col == 0 || col == 7) {
                            score = score - 5;
                        }
                    }
                }
            }
            score = Math.abs(score);

        }
        System.out.println(score);
        return score;
        // 2. jeżeli jest możliwe jakieś bicie to dodaje np. + 15 pkt
        // 3. od wyniku odejmujemy pkt przeciwnika policzone tak samo

    }

}

