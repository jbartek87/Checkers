package com.kodilla.logic;

import com.kodilla.ai.AiLogic;
import com.kodilla.gui.AlertBox;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

import static com.kodilla.logic.FigureColor.BLACK;
import static com.kodilla.logic.FigureColor.WHITE;

public class Board {
    private List<BoardRow> rows = new ArrayList<>();
    public FigureColor whoMoves = BLACK;
    private static Image IMAGE_WHITE = new Image("file:C:\\Users\\cp24\\Desktop\\JavaSptember\\Kodilla\\checkersV3\\src\\main\\resources\\pawnWhite.png");
    private static Image IMAGE_BLACK = new Image("file:C:\\Users\\cp24\\Desktop\\JavaSptember\\Kodilla\\checkersV3\\src\\main\\resources\\pawnBlack.png");
//    public static Image IMAGE_WHITE = null;
//    public static Image IMAGE_BLACK = null;

    public Board() {
        for (int n = 0; n < 10; n++) {
            rows.add(new BoardRow());
        }
    }

    public Board(Board board) {
        for (int n = 0; n < 10; n++) {
            rows.add(new BoardRow());
        }
        for(int col=0; col<8;col++){
            for(int row=0;row<8;row++){
                setFigure(col,row,board.getFigure(col,row));
            }
        }
    }


    public static Image getImageWhite() {
        return IMAGE_WHITE;
    }

    public static Image getImageBlack() {
        return IMAGE_BLACK;
    }


    public Figure getFigure(int col, int row) {
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure) {
        rows.get(row).getCols().add(col, figure);
        rows.get(row).getCols().remove(col + 1);
    }


    public void initBoard() {

        setFigure(0, 0, new Pawn(WHITE));
        setFigure(2, 0, new Pawn(WHITE));
        setFigure(4, 0, new Pawn(WHITE));
        setFigure(6, 0, new Pawn(WHITE));
        setFigure(1, 1, new Pawn(WHITE));
        setFigure(3, 1, new Pawn(WHITE));
        setFigure(5, 1, new Pawn(WHITE));
        setFigure(7, 1, new Pawn(WHITE));
        setFigure(0, 2, new Pawn(WHITE));
        setFigure(2, 2, new Pawn(WHITE));
        setFigure(4, 2, new Pawn(WHITE));
        setFigure(6, 2, new Pawn(WHITE));


        setFigure(0, 6, new Pawn(BLACK));
        setFigure(1, 7, new Pawn(BLACK));
        setFigure(1, 5, new Pawn(BLACK));
        setFigure(2, 6, new Pawn(BLACK));
        setFigure(3, 7, new Pawn(BLACK));
        setFigure(3, 5, new Pawn(BLACK));
        setFigure(4, 6, new Pawn(BLACK));
        setFigure(5, 7, new Pawn(BLACK));
        setFigure(5, 5, new Pawn(BLACK));
        setFigure(6, 6, new Pawn(BLACK));
        setFigure(7, 7, new Pawn(BLACK));
        setFigure(7, 5, new Pawn(BLACK));

        System.out.println("Color " + whoMoves + " " + " starts the game");
    }

    private void doSimpleMove(int col1, int row1, int col2, int row2)throws IndexOutOfBoundsException {
        Figure figure = getFigure(col1, row1);
        setFigure(col1, row1, new None());
        setFigure(col2, row2, figure);
    }

    private void doHitMove(int col1, int row1, int col2, int row2, FigureColor whoMoves) {
        Figure figure = getFigure(col1, row1);
        setFigure(col1, row1, new None());
        if (whoMoves == WHITE && col2 > col1 && row2 > row1) {
            moveWithHit(col2+1, row2+1,col2,row2,figure);

        } else if (whoMoves == WHITE && col1 > col2 && row2 > row1) {
            moveWithHit(col2 - 1, row2 + 1, col2,row2,figure);

        } else if (whoMoves == WHITE && col1 > col2 && row1 > row2) {
            moveWithHit(col2 - 1, row2 - 1,col2,row2, figure);

        } else if (whoMoves == WHITE && col2 > col1 && row1 > row2) {
            moveWithHit(col2 + 1, row2 - 1,col2,row2, figure);

        } else if (whoMoves == BLACK && col2 < col1 && row1 > row2) {
            moveWithHit(col2 - 1, row2 - 1,col2,row2, figure);

        } else if (whoMoves == BLACK && col2 > col1 && row1 > row2) {
            moveWithHit(col2 + 1, row2 - 1,col2,row2, figure);

        } else if (whoMoves == BLACK && col2 > col1 && row2 > row1) {
            moveWithHit(col2 + 1, row2 + 1,col2,row2, figure);

        } else if (whoMoves == BLACK && col1 > col2 && row2 > row1) {
            moveWithHit(col2 - 1, row2 + 1,col2,row2, figure);

        }

    }

    private void moveWithHit(int newCol, int newRow, int col, int row, Figure figure) {
        setFigure(newCol,newRow,figure);
        setFigure(col,row, new None());
    }

    public boolean isSimpleMoveValid(int col1, int row1, int col2, int row2) {
        if(col2==-1||row2==-1||col2==8||row2==8){
            return false;
        } else {
            Figure figure = getFigure(col1, row1);
            Figure moveFigure = getFigure(col2, row2);
            if (figure.getColor() == WHITE && col2 - col1 == 1 && row2 - row1 == 1 && moveFigure instanceof None
                    || figure.getColor() == WHITE && col1 - col2 == 1 && row2 - row1 == 1 && moveFigure instanceof None
                    || figure.getColor() == BLACK && col2 - col1 == 1 && row1 - row2 == 1 && moveFigure instanceof None
                    || figure.getColor() == BLACK && col1 - col2 == 1 && row1 - row2 == 1 && moveFigure instanceof None) {
//                System.out.println("Simple move is true");
                return true;
            }
//            System.out.println("Simple move is false");
            return false;
        }
    }

    public boolean isHitMoveValid(int col1, int row1, int col2, int row2) {
        if(col2==-1||row2==-1||col2==8||row2==8) {
            return false;
        }else {
            Figure figure = getFigure(col1, row1);
            Figure enemyFigure = getFigure(col2, row2);
            if (col2 + 1 == 8 || row2 + 1 == 8 || col2 - 1 == -1 || row2 - 1 == -1) {
                return false;
            } else if (
                    isHitPossible(col1, row1, col2, row2, figure, enemyFigure, WHITE, col2 + 1, row2 + 1)
                            || isHitPossible(col2, row1, col1, row2, figure, enemyFigure, WHITE, col2 - 1, row2 + 1)
                            || isHitPossible(col2, row2, col1, row1, figure, enemyFigure, WHITE, col2 - 1, row2 - 1)
                            || isHitPossible(col1, row2, col2, row1, figure, enemyFigure, WHITE, col2 + 1, row2 - 1)
                            || isHitPossible(col2, row2, col1, row1, figure, enemyFigure, BLACK, col2 - 1, row2 - 1)
                            || isHitPossible(col1, row2, col2, row1, figure, enemyFigure, BLACK, col2 + 1, row2 - 1)
                            || isHitPossible(col1, row1, col2, row2, figure, enemyFigure, BLACK, col2 + 1, row2 + 1)
                            || isHitPossible(col2, row1, col1, row2, figure, enemyFigure, BLACK, col2 - 1, row2 + 1)) {

                return true;
            }
            return false;
        }
    }

    private boolean isHitPossible(int col1, int row1, int col2, int row2, Figure figure, Figure enemyFigure,
                                  FigureColor white, int i, int i2) {

        return figure.getColor() == white && col2 - col1 == 1 && row2 - row1 == 1 && enemyFigure instanceof Pawn &&
                enemyFigure.getColor() != figure.getColor() && getFigure(i, i2) instanceof None;
    }

    public void setOppositeColor() {
        whoMoves = getOpposite(whoMoves);
    }

    private FigureColor getOpposite(FigureColor whoMoves) {
        return (whoMoves == WHITE) ? BLACK : WHITE;
    }

    public void move(int col1, int row1, int col2, int row2) {
        if (getFigure(col1, row1).getColor() != whoMoves) {
            if (isSimpleMoveValid(col1, row1, col2, row2)) {
                doSimpleMove(col1, row1, col2, row2);
                setOppositeColor();
            } else if (isHitMoveValid(col1, row1, col2, row2)) {
                doHitMove(col1, row1, col2, row2,whoMoves);
                int score1 = AiLogic.calculateScore(this, whoMoves);
                int score2 = AiLogic.calculateScore(this, getOpposite(whoMoves));
                if (score1 == 0 || score2 == 0)
                    displayWinner((score1 == 0) ? whoMoves : getOpposite(whoMoves));

            }
//
        }

    }

    private void displayWinner(FigureColor figureColor) {
        System.out.println("Winner");
        AlertBox.display("End of game", whoMoves + " wins");
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
                    s += (figure.getColor() == WHITE) ? "w" : "b";
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
