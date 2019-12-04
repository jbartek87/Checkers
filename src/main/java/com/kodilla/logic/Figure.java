package com.kodilla.logic;

import javafx.scene.image.Image;

public abstract class Figure {
    private FigureColor color;

    public Figure(FigureColor color) {
        this.color = color;
    }

    public FigureColor getColor() {
        return color;
    }

    public abstract Image getImage();
}
