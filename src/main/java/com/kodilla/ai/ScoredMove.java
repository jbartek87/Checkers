package com.kodilla.ai;

public class ScoredMove {
    private Move move;
    private int score;

    public ScoredMove(Move move, int score) {
        this.move = move;
        this.score = score;
    }

    public Move getMove() {
        return move;
    }

    public int getScore() {
        return score;
    }
}
