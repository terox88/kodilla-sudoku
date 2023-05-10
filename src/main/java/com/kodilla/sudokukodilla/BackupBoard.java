package com.kodilla.sudokukodilla;

public class BackupBoard {
    private final SudokuBoard backupBoard;
    private final SudokuData guessedElement;

    public BackupBoard(SudokuBoard backupBoard, SudokuData guessedElement) {
        this.backupBoard = backupBoard;
        this.guessedElement = guessedElement;
    }

    public SudokuBoard getBackupBoard() {
        return backupBoard;
    }

    public SudokuData getGuessedElement() {
        return guessedElement;
    }
}
