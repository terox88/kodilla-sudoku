package com.kodilla.sudokukodilla;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> board = new ArrayList<>();
    public final static int BOARD_SIZE = 9;

    public SudokuBoard() {
        for(int i = 0; i < BOARD_SIZE; i++) {
            board.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getBoard() {
        return board;
    }

    @Override
    public String toString() {
        String result = "";
        for (SudokuRow row : board ) {
            result += "|";
            for(SudokuElement element : row.getSudokuRow()) {
                if(element.getValue() == -1) {
                    result += "   ";
                } else {
                    result += " "  + element.getValue() + " ";
                }
                result +="|";
            }
            result += "\n-------------------------------------\n";
        }
        return result;
    }
    public SudokuBoard deepCopy() {
        SudokuBoard clonedBoard = new SudokuBoard();
        for(int y = 0; y < this.board.size(); y++) {
            SudokuRow clonedRow = new SudokuRow();
            for(int x = 0; x < this.board.size(); x++) {
                clonedRow.getSudokuRow().set(x, new SudokuElement(this.board.get(y).getSudokuRow().get(x).getValue(), this.board.get(y).getSudokuRow().get(x).getPossibleNumbers()));
            }
            clonedBoard.getBoard().set(y, clonedRow);
        }
        return clonedBoard;
    }

}
