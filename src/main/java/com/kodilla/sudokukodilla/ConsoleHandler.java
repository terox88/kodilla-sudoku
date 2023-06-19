package com.kodilla.sudokukodilla;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleHandler {
    private Scanner scanner = new Scanner(System.in);

    public String getUserData() {
        System.out.println("Enter data for sudoku in order: column, row, value it can be multiply or \"SUDOKU\" for get resolve\n");
        return scanner.nextLine();
    }
    public boolean newSudoku() {
        System.out.println("Do you want close program? Y - Yes / N - No");
        String answer = scanner.nextLine().toUpperCase();
        return answer.equals("Y");
    }
    public List<SudokuData> createSudokuData(String data) {

        List<String> helpList = new ArrayList<>();
        List<SudokuData> result = new ArrayList<>();

            String values = data.replaceAll(",", " ").replaceAll(" ","");
            if (values.length() % 3 != 0) {
                System.out.println("Entered data should be 3 values or multiply of 3");
            } else {
                for (int i = 0; i < values.length(); i += 3) {
                    helpList.add(values.substring(i, i + 3));
                }
                for (String sub : helpList) {
                    result.add(new SudokuData(Integer.parseInt(sub.substring(0, 1)), Integer.parseInt(sub.substring(1, 2)), Integer.parseInt(sub.substring(2, 3))));
                }
                for (SudokuData val : result) {
                    boolean value = val.getValue() > 0 && val.getValue() < 10;
                    boolean x = val.getX() > 0 && val.getX() < 10;
                    boolean y = val.getY() > 0 && val.getY() < 10;
                    if (value && x && y) {
                        return result;
                    } else {
                        System.out.println("Entered values must be between 1 and 9");
                    }
                }
            }
            return new ArrayList<>();
    }
}
