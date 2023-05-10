package com.kodilla.sudokukodilla;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SudokuElement {
    private int value;
    public static int EMPTY = -1;
    private List<Integer> possibleNumbers = new LinkedList<>();

    public SudokuElement(int value) {
        this.value = value;
        for (int i = 1; i < 10; i++) {
            possibleNumbers.add(i);
        }
    }

    public SudokuElement(int value, List<Integer> possibleNumbers) {
        this.value = value;
        this.possibleNumbers = possibleNumbers;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void enterValue() {
        if (this.possibleNumbers.size() == 1)
            this.value = this.possibleNumbers.get(0);
    }

    public List<Integer> getPossibleNumbers() {
        return possibleNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuElement element = (SudokuElement) o;

        if (value != element.value) return false;
        return Objects.equals(possibleNumbers, element.possibleNumbers);
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (possibleNumbers != null ? possibleNumbers.hashCode() : 0);
        return result;
    }
}



