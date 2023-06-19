package com.kodilla.sudokukodilla;

import java.util.ArrayList;
import java.util.LinkedList;
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
        for (int i = 0; i < board.size(); i++ ) {
            result += "|";
            for(int j = 0; j < board.get(i).getSudokuRow().size(); j++) {
                SudokuElement element = board.get(i).getSudokuRow().get(j);
                if(element.getValue() == -1) {
                    result += "   ";
                } else {
                    result += " "  + element.getValue() + " ";
                }
                if(j == 2 || j == 5) {
                    result +="||";
                } else {
                    result += "|";
                }

            }
            if(i == 2 || i == 5) {
                result += "\n---------------------------------------\n" + "---------------------------------------\n";
            }else {
                result += "\n---------------------------------------\n";
            }


        }
        return result;
    }
    public SudokuBoard deepCopy() {
        SudokuBoard clonedBoard = new SudokuBoard();
        for(int y = 0; y < this.board.size(); y++) {
            SudokuRow clonedRow = new SudokuRow();
            for(int x = 0; x < this.board.size(); x++) {
                List<Integer> clonedNumbers = new LinkedList<>();
                for(int number :this.board.get(y).getSudokuRow().get(x).getPossibleNumbers()) {
                    clonedNumbers.add(number);
                }
                clonedRow.getSudokuRow().set(x, new SudokuElement(this.board.get(y).getSudokuRow().get(x).getValue(), clonedNumbers));
            }
            clonedBoard.getBoard().set(y, clonedRow);
        }
        return clonedBoard;
    }

}
