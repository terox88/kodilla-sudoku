package com.kodilla.sudokukodilla;

import java.util.List;

public class SudokuData {

    private final int x;
    private final int y;
    private final int value;

    public SudokuData(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getValue() {
        return value;
    }
}
