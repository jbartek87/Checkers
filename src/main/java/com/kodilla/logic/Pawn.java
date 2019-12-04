package com.kodilla.logic;

import javafx.scene.image.Image;

public class Pawn extends Figure {
    private static Image IMAGE_WHITE = new Image("file:C:\\Users\\cp24\\Desktop\\JavaSptember\\Kodilla\\checkersV3\\src\\main\\resources\\pawnWhite.png");
    private static Image IMAGE_BLACK = new Image("file:C:\\Users\\cp24\\Desktop\\JavaSptember\\Kodilla\\checkersV3\\src\\main\\resources\\pawnBlack.png");

    public Pawn(FigureColor color) {
        super(color);
    }

    @Override
    public Image getImage() {
        if (getColor() == FigureColor.WHITE)
            return IMAGE_WHITE;
        if (getColor() == FigureColor.BLACK)
            return IMAGE_BLACK;
        return null;
    }
}
