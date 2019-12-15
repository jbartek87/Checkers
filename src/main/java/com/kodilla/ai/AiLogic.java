package com.kodilla.ai;

import com.kodilla.logic.Board;
import com.kodilla.logic.FigureColor;

import java.util.ArrayList;

public class AiLogic {
    public Move getBestMove(Board board, FigureColor whoMoves, int stepsCount) {
        // 1. Zbudować listę wszystkich mozliwych ruchów

        ArrayList<Move> possibleMovesWhite = new ArrayList<>();
        ArrayList<Move> possibleMovesBlack = new ArrayList<>();
        int count = 0;

        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                if (whoMoves == FigureColor.BLACK) {
                    if (board.isSimpleMoveValid(col, row, col + 1, row + 1))
                        possibleMovesBlack.add(new Move(col, row, col + 1, row + 1));
                    count++;
                    if (board.isSimpleMoveValid(col, row, col - 1, row + 1))
                        possibleMovesBlack.add(new Move(col, row, col - 1, row + 1));
                    count++;
                }

//                else if (whoMoves == FigureColor.WHITE) {
//                    if (board.isSimpleMoveValid(col, row, col + 1, row - 1))
//                        possibleMovesWhite.add(new Move(col, row, col + 1, row - 1));
//                    count++;
//                    if (board.isSimpleMoveValid(col, row, col - 1, row - 1))
//                        possibleMovesWhite.add(new Move(col, row, col - 1, row - 1));
//                    count++;
//                }
            }
        }

        System.out.println(count);

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

    private int calculateScore(Board board, FigureColor whoMoves) {
        // 1. sumuje dla każdej figury koloru whoMoves na planszy jej odległość od krawędzi bazowej
        // 2. jeżeli jest możliwe jakieś bicie to dodaje np. + 15 pkt
        // 3. od wyniku odejmujemy pkt przeciwnika policzone tak samo

        return 0;
    }

    }

