package com.kodilla.logic;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();

    public Board() {
        for(int n=0; n<8;n++){
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

    public void iniBoard() {
        //ustawić początkowe położenie pionków na planszy przy pomocy setFigure
    }

    public void move(int col1, int row1, int co2, int row2){
        // przenoszenie figury z col1/row1 na col2/row2
    }

    @Override
    public String toString() {
        String s = "|-----------------------|\n";
        for(int row=0; row<8;row++){
            s+="|";
            for(int col=0;col<8;col++){
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
        s+="|-----------------------|\n";
        return s;
    }
}
