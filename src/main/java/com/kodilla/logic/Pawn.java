package com.kodilla.logic;

import javafx.scene.image.Image;

public class Pawn extends Figure {



    public Pawn(FigureColor color) {
        super(color);

    }

    @Override
    public Image getImage() {
        if (getColor() == FigureColor.WHITE)
           return Board.getImageBlack();
        if (getColor() == FigureColor.BLACK)
           return Board.getImageWhite();
        return null;
    }
}
