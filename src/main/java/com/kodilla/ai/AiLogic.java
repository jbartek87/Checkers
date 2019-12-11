package com.kodilla.ai;

import com.kodilla.logic.Board;
import com.kodilla.logic.FigureColor;

public class AiLogic {
    public Move getBestMove(Board board, FigureColor whoMoves, int stepsCount){
        // 1. Zbudować listę wszystkich mozliwych ruchów
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

    private int calculateScore(Board board, FigureColor whoMoves){
        // 1. sumuje dla każdej figury koloru whoMoves na planszy jej odległość od krawędzi bazowej
        // 2. jeżeli jest możliwe jakieś bicie to dodaje np. + 15 pkt
        // 3. od wyniku odejmujemy pkt przeciwnika policzone tak samo

        return 0;
    }
}
