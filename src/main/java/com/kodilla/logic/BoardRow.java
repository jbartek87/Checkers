package com.kodilla.logic;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {
    private List<Figure> cols = new ArrayList<>();

    public BoardRow() {
        for(int n=0;n<10;n++){
            cols.add(new None());
        }
    }

    public List<Figure> getCols(){
        return cols;
    }
}
