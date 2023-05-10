package com.kodilla.sudokukodilla;
import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> sudokuRow = new ArrayList<>();

    public SudokuRow() {
        for( int i = 0; i < SudokuBoard.BOARD_SIZE; i++) {
            sudokuRow.add(new SudokuElement(SudokuElement.EMPTY));
        }
    }
    public List<SudokuElement> getSudokuRow() {
        return sudokuRow;
    }
}
