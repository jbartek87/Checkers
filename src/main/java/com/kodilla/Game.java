package com.kodilla;

import com.kodilla.logic.Board;
import com.kodilla.logic.Figure;
import com.kodilla.logic.Pawn;
import com.kodilla.logic.Queen;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Game {
    private Board board;
    private GridPane gridPane;
    private int oldX=-1;
    private int oldY=-1;

    public Game(Board board, GridPane gridPane) {
        this.board = board;
        this.gridPane = gridPane;
    }

    public void showBoard(){
        gridPane.getChildren().clear();
        for(int row=0;row<8;row++){
            for(int col=0;col<8;col++){
                Figure figure = board.getFigure(col,row);
                if(figure instanceof Pawn || figure instanceof Queen){
                    if(col==oldX&&row==oldY){
                        //wyśw pod figurą obiekt typu rectangle w kolorze dowolnym
                        Rectangle rec = new Rectangle();
                        rec.setWidth(80);
                        rec.setHeight(80);
                        rec.setFill(Color.web("#ed4b00"));
                        GridPane.setColumnIndex(rec, col);
                        GridPane.setRowIndex(rec,row);
                        gridPane.getChildren().addAll(rec);

                    }
                    ImageView img = new ImageView(figure.getImage());
                    gridPane.add(img,col,row);

                }
            }
        }
    }

    public void doClick(int x, int y) {
        if(oldX==-1){
            oldX=x;
            oldY=y;
        } else {
            board.move(oldX, oldY, x, y);
            oldX=-1;
        }
        showBoard();
    }
}
