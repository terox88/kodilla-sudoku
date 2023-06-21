package com.kodilla.sudokukodilla;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SudokuGame {
    private SudokuBoard board;
    private final ConsoleHandler handler;
    private List<BackupBoard> backtrack = new ArrayList<>();
    private long counter =0l;

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
                        } else if (element.getValue() != -1 && board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().size() == 1) {
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
                        if (board.getBoard().get(y).getSudokuRow().get(x).getValue() == element.getValue() && board.getBoard().get(y).getSudokuRow().get(x) != element) {
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
                } else {
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
                || fieldCheck(0, 0) || fieldCheck(0, 3) || fieldCheck(0, 6)
                || fieldCheck(3, 0) || fieldCheck(3, 3) || fieldCheck(3, 6)
                || fieldCheck(6, 0) || fieldCheck(6, 3) || fieldCheck(6, 6);
    }

    public boolean isResolved() {
        long result = board.getBoard().stream().flatMap(row -> row.getSudokuRow().stream())
                .map(val -> val.getValue())
                .filter(v -> v == -1)
                .count();
        return result == 0;
    }

    public SudokuData findGuessedValue() {
        SudokuElement element;
        Random random = new Random();
        while(true) {
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            if (board.getBoard().get(y).getSudokuRow().get(x).getValue() == -1) {
                element = board.getBoard().get(y).getSudokuRow().get(x);
                return new SudokuData(x, y, element.getPossibleNumbers().get(random.nextInt(element.getPossibleNumbers().size())));
            }
        }
    }


    public void restoreBoard(BackupBoard restoredBoard) {
        if(counter > 1000) {
            board = backtrack.get(0).getBackupBoard();
            backtrack.clear();
            backtrack.add(new BackupBoard(board.deepCopy(), new SudokuData(0, 0, 0)));
            counter = 0;
        }else {
            board = restoredBoard.getBackupBoard();
            int x = restoredBoard.getGuessedElement().getX();
            int y = restoredBoard.getGuessedElement().getY();
            int value = restoredBoard.getGuessedElement().getValue();
            if (board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().size() > 1) {
                board.getBoard().get(y).getSudokuRow().get(x).getPossibleNumbers().remove(Integer.valueOf(value));
            }
            backtrack.remove(restoredBoard);
        }

    }
    public void backupMaking(SudokuData data) {
        backtrack.add(new BackupBoard(board.deepCopy(), data));
    }
    public void guessing(SudokuData data) {
        board.getBoard().get(data.getY()).getSudokuRow().get(data.getX()).setValue(data.getValue());
    }

    public boolean sudokuResolve() {
        boolean isResolved = false;
        while (!isResolved) {
            System.out.println("\n" + board);
            String userData = handler.getUserData().toUpperCase();
            if (userData.equals("SUDOKU")) {
                boolean end = false;
                backtrack.add(new BackupBoard(board.deepCopy(), new SudokuData(0,0,0)));
                while (!end) {
                    boolean boardCheck = false;
                    counter++;
                    try {
                        boardCheck = allCheck();
                    } catch (CanotResolveSudokuException e) {
                        if (backtrack.size() > 1) {
                            restoreBoard(backtrack.get(backtrack.size()-1));
                        } else {
                            System.out.println("This sudoku cannot be solved");
                            end = true;
                            backtrack.clear();
                            board = new SudokuBoard();
                            isResolved = handler.newSudoku();
                        }
                    }
                    if (boardCheck && !end) {
                        end = isResolved();

                    } else if(!boardCheck && !end) {
                        SudokuData data = findGuessedValue();
                        backupMaking(data);
                        guessing(data);
                    }


                }
                if(isResolved()) {
                    System.out.println("This is yours sudoku solved. It took " + counter + " loops to solve");
                    System.out.println();
                    System.out.println(board);
                    backtrack.clear();
                    board = new SudokuBoard();
                    counter = 0;
                    isResolved = handler.newSudoku();
                }

            } else {
                List<SudokuData> sudokuData = new ArrayList<>();
                boolean done = false;
                while (!done) {
                    sudokuData = handler.createSudokuData(userData);
                    if (sudokuData.size() > 0) {
                        done = true;
                    } else {
                        userData = handler.getUserData();
                    }
                }
                setTheBoard(sudokuData);
            }

        }
        return isResolved;
    }
}


