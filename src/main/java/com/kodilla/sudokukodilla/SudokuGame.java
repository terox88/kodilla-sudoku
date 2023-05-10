package com.kodilla.sudokukodilla;

import java.util.ArrayList;
import java.util.List;

public class SudokuGame {
    private SudokuBoard board;
    private final ConsoleHandler handler;
    private List<BackupBoard> backtrack = new ArrayList<>();

    public SudokuGame() {
        this.board = new SudokuBoard();
        this.handler = new ConsoleHandler();
    }

    public SudokuBoard getBoard() {
        return board;
    }


    public boolean setTheBoard(List<SudokuData> data) {

        if (data.isEmpty()) {
            return false;
        } else {
            for (SudokuData sudoku : data) {
                board.getBoard().get(sudoku.getY() - 1).getSudokuRow().set(sudoku.getX() - 1, new SudokuElement(sudoku.getValue()));
            }
            return true;
        }
    }

    public boolean checkRows() throws CanotResolveSudokuException {
        boolean result = false;
        for (int y = 0; y < board.getBoard().size(); y++) {
            for (int x = 0; x < board.getBoard().size(); x++) {
                if (board.getBoard().get(y).getSudokuRow().get(x).getValue() == -1) {
                    for (SudokuElement element : board.getBoard().get(y).getSudokuRow()) {
                        if (element.getValue() != -1 && board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().contains(element.getValue()) && board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().size() > 1) {
                            board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().remove(Integer.valueOf(element.getValue()));
                            result = true;
                        }else if (element.getValue() != -1 && board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().size() == 1) {
                                if (board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().contains(element.getValue())) {
                                    throw new CanotResolveSudokuException();
                                }

                        }
                    }
                    if (board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().size() == 1) {
                        board.getBoard().get(y).getSudokuRow().get(x).enterValue();
                        result = true;
                    }
                } else {
                    for (SudokuElement element : board.getBoard().get(y).getSudokuRow()) {
                        if(board.getBoard().get(y).getSudokuRow().get(x).getValue() == element.getValue() && board.getBoard().get(y).getSudokuRow().get(x) != element) {
                            throw new CanotResolveSudokuException();
                        }
                    }
                }
                    }
                }
        return result;
    }

    public boolean checkColumns() throws CanotResolveSudokuException {
        boolean result = false;
        for (int y = 0; y < board.getBoard().size(); y++) {
            for (int x = 0; x < board.getBoard().size(); x++) {
                if (board.getBoard().get(y).getSudokuRow().get(x).getValue() == -1) {
                    for (int i = 0; i < board.getBoard().size(); i++) {
                        SudokuElement element = board.getBoard().get(i).getSudokuRow().get(x);
                        if (element.getValue() != -1 && board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().contains(element.getValue()) && board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().size() > 1) {
                            board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().remove(Integer.valueOf(element.getValue()));
                            result = true;
                        } else if (element.getValue() != -1 && board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().size() == 1) {
                            if (element.getValue() == board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().get(0)) {
                                throw new CanotResolveSudokuException();

                            }
                        }
                    }
                    if (board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().size() == 1) {
                        board.getBoard().get(y).getSudokuRow().get(x).enterValue();
                        result = true;
                    }
                } else  {
                    for (int i = 0; i < board.getBoard().size(); i++) {
                        SudokuElement element = board.getBoard().get(i).getSudokuRow().get(x);
                        if (board.getBoard().get(y).getSudokuRow().get(x).getValue() == element.getValue() && board.getBoard().get(y).getSudokuRow().get(x) != element) {
                            throw new CanotResolveSudokuException();
                        }

                    }
                }
            }

        }
        return result;
    }

    public boolean fieldCheck(int beginX, int beginY) throws CanotResolveSudokuException {
        boolean result = false;
        for (int y = beginY; y < beginY + 3; y++) {
            for (int x = beginX; x < beginX + 3; x++) {
                if (board.getBoard().get(y).getSudokuRow().get(x).getValue() == -1) {
                    for (int i = beginY; i < beginY + 3; i++) {
                        for (int j = beginX; j < beginX + 3; j++) {
                            SudokuElement element = board.getBoard().get(i).getSudokuRow().get(j);
                            if (element.getValue() != -1 && board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().contains(element.getValue()) && board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().size() > 1) {
                                board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().remove(Integer.valueOf(element.getValue()));
                                result = true;
                            } else if (element.getValue() != -1 && board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().size() == 1) {
                                if (element.getValue() == board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().get(0)) {
                                    throw new CanotResolveSudokuException();
                                }
                            }
                        }
                    }
                    if (board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().size() == 1) {
                        board.getBoard().get(y).getSudokuRow().get(x).enterValue();
                        result = true;
                    }

                } else {
                    for (int i = beginY; i < beginY + 3; i++) {
                        for (int j = beginX; j < beginX + 3; j++) {
                            SudokuElement element = board.getBoard().get(i).getSudokuRow().get(j);
                            if (board.getBoard().get(y).getSudokuRow().get(x).getValue() == element.getValue() && board.getBoard().get(y).getSudokuRow().get(x) != element) {
                                throw new CanotResolveSudokuException();
                            }

                        }

                    }
                }

            }
        }
        return result;
    }
    public boolean allCheck() throws CanotResolveSudokuException {
        return checkRows() || checkColumns()
                || fieldCheck(0,0)|| fieldCheck(0,3) || fieldCheck(0, 6)
                || fieldCheck(3,0) || fieldCheck(3,3) || fieldCheck(3, 6)
                ||fieldCheck(6, 0) || fieldCheck(6, 3) || fieldCheck(6, 6);
    }
    public boolean isResolved() {
        long result = board.getBoard().stream().flatMap(row -> row.getSudokuRow().stream())
                .map(val -> val.getValue())
                .filter(v -> v == -1)
                .count();
        return result == 0;
    }
    public SudokuData findGuessedValue () {
        SudokuElement element = new SudokuElement(-1, List.of(0,1,2,3,4,5,6,7,8,9));
        SudokuData data = null;
        for (int y = 0; y < board.getBoard().size(); y++) {
            for (int x = 0; x < board.getBoard().size(); x++) {
                if(board.getBoard().get(y).getSudokuRow().get(x).getValue() == -1 && board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().size() < element.getPossibleNumbers().size()) {
                    element = board.getBoard().get(y).getSudokuRow().get(x);
                    data = new SudokuData(x, y, element.getPossibleNumbers().get(0));

                }
            }
        }
        return data;
    }
    public void restoreBoard(BackupBoard restoredBoard) {
        board = restoredBoard.getBackupBoard();
        int x = restoredBoard.getGuessedElement().getX();
        int y = restoredBoard.getGuessedElement().getY();
        int value = restoredBoard.getGuessedElement().getValue();
        if(board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().size() > 1) {
            board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().remove(Integer.valueOf(value));
        }
        backtrack.remove(restoredBoard);

    }
    public void backupMaking (SudokuData data) {
        backtrack.add(new BackupBoard(board.deepCopy(),data));
    }
    public void guessing (SudokuData data) {
        board.getBoard().get(data.getY()).getSudokuRow().get(data.getX()).setValue(data.getValue());
    }
    public boolean sudokuResolve() {
        boolean isResolved = false;
        while (!isResolved) {
            board = new SudokuBoard();
            String userData = handler.getUserData().toUpperCase();
            if(userData.equals("SUDOKU")) {
                boolean end = false;
                while (!end) {
                    boolean boardCheck = false;
                    try {
                        boardCheck = allCheck();
                    } catch (CanotResolveSudokuException e) {
                        if(backtrack.size() > 0) {
                            restoreBoard(backtrack.get(0));
                        } else {
                            System.out.println("This sudoku cannot be solved");
                            end = true;
                        }
                    }
                    if(boardCheck) {
                        end = isResolved();

                    } else {
                        SudokuData data = findGuessedValue();
                        backupMaking(data);
                        guessing(data);
                    }

                }
                System.out.println("This is yours sudoku solved");
                System.out.println();
                System.out.println(board);
                isResolved = handler.newSudoku();


            } else {
                List<SudokuData> sudokuData = new ArrayList<>();
                while (sudokuData.size() == 0) {
                    sudokuData = handler.createSudokuData(userData);
                }
                setTheBoard(sudokuData);
                System.out.println(board);
            }
        }
        return isResolved;
    }
}


