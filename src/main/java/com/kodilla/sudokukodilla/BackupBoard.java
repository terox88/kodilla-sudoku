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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BackupBoard that = (BackupBoard) o;

        if (!backupBoard.equals(that.backupBoard)) return false;
        return guessedElement.equals(that.guessedElement);
    }

    @Override
    public int hashCode() {
        int result = backupBoard.hashCode();
        result = 31 * result + guessedElement.hashCode();
        return result;
    }
}
