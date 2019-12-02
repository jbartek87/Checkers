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

    public void iniBoard(Board board) {

        board.setFigure(1, 0, new Pawn(FigureColor.WHITE));
        board.setFigure(3, 0, new Pawn(FigureColor.WHITE));
        board.setFigure(5, 0, new Pawn(FigureColor.WHITE));
        board.setFigure(7, 0, new Pawn(FigureColor.WHITE));
        board.setFigure(9, 0, new Pawn(FigureColor.WHITE));
        board.setFigure(0, 1, new Pawn(FigureColor.WHITE));
        board.setFigure(2, 1, new Pawn(FigureColor.WHITE));
        board.setFigure(4, 1, new Pawn(FigureColor.WHITE));
        board.setFigure(6, 1, new Pawn(FigureColor.WHITE));
        board.setFigure(8, 1, new Pawn(FigureColor.WHITE));
        board.setFigure(1, 2, new Pawn(FigureColor.WHITE));
        board.setFigure(3, 2, new Pawn(FigureColor.WHITE));
        board.setFigure(5, 2, new Pawn(FigureColor.WHITE));
        board.setFigure(7, 2, new Pawn(FigureColor.WHITE));
        board.setFigure(9, 2, new Pawn(FigureColor.WHITE));
        board.setFigure(0, 3, new Pawn(FigureColor.WHITE));
        board.setFigure(2, 3, new Pawn(FigureColor.WHITE));
        board.setFigure(4, 3, new Pawn(FigureColor.WHITE));
        board.setFigure(6, 3, new Pawn(FigureColor.WHITE));
        board.setFigure(8, 3, new Pawn(FigureColor.WHITE));

        board.setFigure(1, 6, new Pawn(FigureColor.BLACK));
        board.setFigure(3, 6, new Pawn(FigureColor.BLACK));
        board.setFigure(5, 6, new Pawn(FigureColor.BLACK));
        board.setFigure(7, 6, new Pawn(FigureColor.BLACK));
        board.setFigure(9, 6, new Pawn(FigureColor.BLACK));
        board.setFigure(0, 7, new Pawn(FigureColor.BLACK));
        board.setFigure(2, 7, new Pawn(FigureColor.BLACK));
        board.setFigure(4, 7, new Pawn(FigureColor.BLACK));
        board.setFigure(6, 7, new Pawn(FigureColor.BLACK));
        board.setFigure(8, 7, new Pawn(FigureColor.BLACK));
        board.setFigure(1, 8, new Pawn(FigureColor.BLACK));
        board.setFigure(3, 8, new Pawn(FigureColor.BLACK));
        board.setFigure(5, 8, new Pawn(FigureColor.BLACK));
        board.setFigure(7, 8, new Pawn(FigureColor.BLACK));
        board.setFigure(9, 8, new Pawn(FigureColor.BLACK));
        board.setFigure(0, 9, new Pawn(FigureColor.BLACK));
        board.setFigure(2, 9, new Pawn(FigureColor.BLACK));
        board.setFigure(4, 9, new Pawn(FigureColor.BLACK));
        board.setFigure(6, 9, new Pawn(FigureColor.BLACK));
        board.setFigure(8, 9, new Pawn(FigureColor.BLACK));

    }

    public void move(int col1, int row1, int col2, int row2) {
        Figure figure = getFigure(col1, row1);
        Figure moveFigure = getFigure(col2, row2);
        if (figure instanceof None) {
            System.out.println("This field is empty");
        } else if (moveFigure instanceof Pawn || moveFigure instanceof Queen) {
            System.out.println("You cannot make this move");
        } else if (figure.getColor() == FigureColor.WHITE && figure instanceof Pawn && row2 < row1) {
            System.out.println("You can't go BACK !");
        } else if (figure.getColor() == FigureColor.WHITE && figure instanceof Pawn && col2 == col1 || row1==row2 || col1 + 2 <= col2 || row1 + 2 < row2) {
            System.out.println("This move is not proper !");
        }  else if (figure.getColor() == FigureColor.BLACK && figure instanceof Pawn && row2 > row1) {
            System.out.println("You can't go BACK !");
        } else if (figure.getColor() == FigureColor.BLACK && figure instanceof Pawn && col2 == col1 || col1 - 2 >= col2 || row1 - 2 > row2) {
            System.out.println("This move is not properr !");
        } else {
            setFigure(col1, row1, new None());
            setFigure(col2, row2, figure);
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
;