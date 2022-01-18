package com.company;

import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrayInt = getNextLine(scanner);

        String[][] matrix = new String[Integer.parseInt(arrayInt[0])][Integer.parseInt(arrayInt[1])];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = getNextLine(scanner);
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            if (tokens[0].equals("swap")) {
                int firstRow = Integer.parseInt(tokens[1]);
                int firstColl = Integer.parseInt(tokens[2]);
                int secondRow = Integer.parseInt(tokens[3]);
                int secondColl = Integer.parseInt(tokens[4]);
                if (firstRow > Integer.parseInt(arrayInt[0]) || secondRow > Integer.parseInt(arrayInt[0])
                        || secondColl > Integer.parseInt(arrayInt[1]) || firstColl > Integer.parseInt(arrayInt[1])) {
                    printInvalidInput();
                } else {
                    String firstString = matrix[firstRow][firstColl];
                    String secondString = matrix[secondRow][secondColl];
                    matrix[firstRow][firstColl] = secondString;
                    matrix[secondRow][secondColl] = firstString;

                    printMatrix(matrix);
                }
            } else {
                printInvalidInput();
            }
            input = scanner.nextLine();
        }
    }

    private static void printInvalidInput() {
        System.out.println("Invalid input!");
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static String[] getNextLine(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
