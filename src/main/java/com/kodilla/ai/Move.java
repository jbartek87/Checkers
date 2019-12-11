package com.kodilla.ai;

public class Move {
    private int col1;
    private int row1;
    private int col2;
    private int row2;

    public Move(int col1, int row1, int col2, int row2) {
        this.col1 = col1;
        this.row1 = row1;
        this.col2 = col2;
        this.row2 = row2;
    }

    public int getCol1() {
        return col1;
    }

    public int getRow1() {
        return row1;
    }

    public int getCol2() {
        return col2;
    }

    public int getRow2() {
        return row2;
    }
}
