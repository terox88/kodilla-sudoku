package com.kodilla.sudokukodilla;

import java.util.List;

public class SudokuApp {
    public static void main(String[] args) {
        SudokuGame game = new SudokuGame();
        boolean isResolved = false;
        while (!isResolved) {
            isResolved = game.sudokuResolve();
        }

    }
}
