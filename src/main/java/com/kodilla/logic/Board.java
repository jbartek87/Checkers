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
