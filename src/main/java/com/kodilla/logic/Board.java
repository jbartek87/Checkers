package com.kodilla.logic;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();

    public Board() {
        for (int n = 0; n < 10; n++) {
            rows.add(new BoardRow());
        }
    }

    public Figure getFigure(int col, int row){
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure){
        rows.get(row).getCols().add(col, figure);
        rows.get(row).getCols().remove(col + 1);
    }

    public void initBoard() {

        setFigure(0, 0, new Pawn(FigureColor.WHITE));
        setFigure(2, 0, new Pawn(FigureColor.WHITE));
        setFigure(4, 0, new Pawn(FigureColor.WHITE));
        setFigure(6, 0, new Pawn(FigureColor.WHITE));
        setFigure(1, 1, new Pawn(FigureColor.WHITE));
        setFigure(3, 1, new Pawn(FigureColor.WHITE));
        setFigure(5, 1, new Pawn(FigureColor.WHITE));
        setFigure(7, 1, new Pawn(FigureColor.WHITE));
        setFigure(0, 2, new Pawn(FigureColor.WHITE));
        setFigure(2, 2, new Pawn(FigureColor.WHITE));
        setFigure(4, 2, new Pawn(FigureColor.WHITE));
        setFigure(6, 2, new Pawn(FigureColor.WHITE));


        setFigure(0, 6, new Pawn(FigureColor.BLACK));
        setFigure(1, 7, new Pawn(FigureColor.BLACK));
        setFigure(1, 5, new Pawn(FigureColor.BLACK));
        setFigure(2, 6, new Pawn(FigureColor.BLACK));
        setFigure(3, 7, new Pawn(FigureColor.BLACK));
        setFigure(3, 5, new Pawn(FigureColor.BLACK));
        setFigure(4, 6, new Pawn(FigureColor.BLACK));
        setFigure(5, 7, new Pawn(FigureColor.BLACK));
        setFigure(5, 5, new Pawn(FigureColor.BLACK));
        setFigure(6, 6, new Pawn(FigureColor.BLACK));
        setFigure(7, 7, new Pawn(FigureColor.BLACK));
        setFigure(7, 5, new Pawn(FigureColor.BLACK));


    }

    private void doSimpleMove(int col1, int row1, int col2, int row2) {
        Figure figure = getFigure(col1, row1);
        setFigure(col1, row1, new None());
        setFigure(col2, row2, figure);
    }

    private void doHitMove(int col1, int row1, int col2, int row2) {
        Figure figure = getFigure(col1, row1);
        Figure moveFigure = getFigure(col2, row2);
        setFigure(col1, row1, new None());
        if (figure.getColor() == FigureColor.WHITE && col2 > col1 && row2 > row1) {
            setFigure(col2 + 1, row2 + 1, figure);
            setFigure(col2, row2, new None());
        } else if (figure.getColor() == FigureColor.WHITE && col1 > col2 && row2 > row1) {
            setFigure(col2 - 1, row2 + 1, figure);
            setFigure(col2, row2, new None());

        } else if (figure.getColor() == FigureColor.WHITE && col1 > col2 && row1 > row2) {
            setFigure(col2 - 1, row2 - 1, figure);
            setFigure(col2, row2, new None());

        } else if (figure.getColor() == FigureColor.WHITE && col2 > col1 && row1 > row2) {
            setFigure(col2 + 1, row2 - 1, figure);
            setFigure(col2, row2, new None());

        } else if (figure.getColor() == FigureColor.BLACK && col2 < col1 && row1 > row2) {
            setFigure(col2 - 1, row2 - 1, figure);
            setFigure(col2, row2, new None());
        } else if (figure.getColor() == FigureColor.BLACK && col2 > col1 && row1 > row2) {
            setFigure(col2 + 1, row2 - 1, figure);
            setFigure(col2, row2, new None());
        } else if (figure.getColor() == FigureColor.BLACK && col2 > col1 && row2 > row1) {
            setFigure(col2 + 1, row2 + 1, figure);
            setFigure(col2, row2, new None());

        } else if (figure.getColor() == FigureColor.BLACK && col1 > col2 && row2 > row1) {
            setFigure(col2 - 1, row2 + 1, figure);
            setFigure(col2, row2, new None());

        }

    }

    private boolean isSimpleMoveValid(int col1, int row1, int col2, int row2) {
        Figure figure = getFigure(col1, row1);
        Figure moveFigure = getFigure(col2, row2);
        if (figure.getColor() == FigureColor.WHITE && col2 - col1 == 1 && row2 - row1 == 1 && moveFigure instanceof None
                || figure.getColor() == FigureColor.WHITE && col1 - col2 == 1 && row2 - row1 == 1 && moveFigure instanceof None
                || figure.getColor() == FigureColor.BLACK && col2 - col1 == 1 && row1 - row2 == 1 && moveFigure instanceof None
                || figure.getColor() == FigureColor.BLACK && col1 - col2 == 1 && row1 - row2 == 1 && moveFigure instanceof None) {
            System.out.println("Simple move is true");
            return true;
        }
        System.out.println("Simple move is false");
        return false;
    }

    private boolean isHitMoveValid(int col1, int row1, int col2, int row2) {
        Figure figure = getFigure(col1, row1);
        Figure moveFigure = getFigure(col2, row2);
        if (col2 + 1 == 8 || row2 + 1 == 8 || col2 - 1 == -1 || row2 - 1 == -1) {
            System.out.println("Hit move is false");
            return false;
        } else if (
                figure.getColor() == FigureColor.WHITE && col2 - col1 == 1 && row2 - row1 == 1 && moveFigure instanceof Pawn && getFigure(col2 + 1, row2 + 1) instanceof None
                        || figure.getColor() == FigureColor.WHITE && col1 - col2 == 1 && row2 - row1 == 1 && moveFigure instanceof Pawn && getFigure(col2 - 1, row2 + 1) instanceof None
                        || figure.getColor() == FigureColor.WHITE && col1 - col2 == 1 && row1 - row2 == 1 && moveFigure instanceof Pawn && getFigure(col2 - 1, row2 - 1) instanceof None
                        || figure.getColor() == FigureColor.WHITE && col2 - col1 == 1 && row1 - row2 == 1 && moveFigure instanceof Pawn && getFigure(col2 + 1, row2 - 1) instanceof None
                        || figure.getColor() == FigureColor.BLACK && col1 - col2 == 1 && row1 - row2 == 1 && moveFigure instanceof Pawn && getFigure(col2 - 1, row2 - 1) instanceof None
                        || figure.getColor() == FigureColor.BLACK && col2 - col1 == 1 && row1 - row2 == 1 && moveFigure instanceof Pawn && getFigure(col2 + 1, row2 - 1) instanceof None
                        || figure.getColor() == FigureColor.BLACK && col2 - col1 == 1 && row2 - row1 == 1 && moveFigure instanceof Pawn && getFigure(col2 + 1, row2 + 1) instanceof None
                        || figure.getColor() == FigureColor.BLACK && col1 - col2 == 1 && row2 - row1 == 1 && moveFigure instanceof Pawn && getFigure(col2 - 1, row2 + 1) instanceof None) {

            System.out.println("Hit move is true");
            return true;
        }
        System.out.println("Hit move is false");
        return false;
    }


    public void move(int col1, int row1, int col2, int row2) throws IndexOutOfBoundsException {
        try {
            if (isSimpleMoveValid(col1, row1, col2, row2)) {
                doSimpleMove(col1, row1, col2, row2);
            } else if (isHitMoveValid(col1, row1, col2, row2)) {
                doHitMove(col1, row1, col2, row2);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid move");
        }
    }


    @Override
    public String toString() {
        String s = "|-----------------------------|\n";
        for (int row = 0; row < 10; row++) {
            s+="|";
            for (int col = 0; col < 10; col++) {
                Figure figure = getFigure(col,row);
                if(figure instanceof None){
                    s+="  ";
                } else {
                    s+=(figure.getColor() == FigureColor.WHITE) ? "w" : "b";
                    s+=(figure instanceof Queen) ? "Q" : "P";
                }
                s+="|";
            }
            s+="\n";
        }
        s += "|-----------------------------|\n";
        return s;
    }

}
