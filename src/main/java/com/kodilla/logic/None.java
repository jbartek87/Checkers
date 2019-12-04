package com.kodilla.logic;

import javafx.scene.image.Image;

public class None extends Figure {
    public None() {
        super(FigureColor.NONE);
    }

    @Override
    public Image getImage() {
        return null;
    }
}
