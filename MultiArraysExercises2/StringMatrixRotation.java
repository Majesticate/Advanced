package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rotation = scanner.nextLine().split("\\(");
        String replace = rotation[1].replace(")", "");
        int intRotation = Integer.parseInt(replace);

        List<String> inputs = new ArrayList<>();
        int matrixLength = 0;

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            inputs.add(input);
            if (input.length() > matrixLength) {
                matrixLength = input.length();
            }
            input = scanner.nextLine();
        }

        if (intRotation == 180 || intRotation == 360) {
            Character[][] matrix = new Character[inputs.size()][matrixLength];
            if (intRotation == 180) {
                int row = matrix.length - 1;
                for (int i = 0; i < matrix.length; i++) {
                    int collum = matrixLength - 1;
                    String currentString = inputs.get(i);
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (j > currentString.length() - 1) {
                            matrix[i + row][j + collum] = ' ';
                            collum -= 2;
                            continue;
                        }
                        char currentChar = currentString.charAt(j);
                        matrix[i + row][j + collum] = currentChar;
                        collum -= 2;
                    }
                    row -= 2;
                }
            } else {
                for (int i = 0; i < matrix.length; i++) {
                    String currentString = inputs.get(i);
                    for (int j = 0; j < inputs.get(i).length(); j++) {
                        char currentChar = currentString.charAt(j);
                        matrix[i][j] = currentChar;
                    }
                }
            }
        } else {
            Character[][] matrix = new Character[matrixLength][inputs.size()];
            if (intRotation == 90) {
                int coll2 = 0;
                for (int row = 0; row < matrix[row].length; row++) {
                    int row2 = -coll2;
                    int lastColl = matrix[row].length - 1 - coll2;
                    String currentString = inputs.get(row);
                    for (int coll = 0; coll < matrixLength; coll++) {
                        if (coll > currentString.length() - 1) {
                            matrix[row + row2][lastColl] = ' ';
                            row2++;
                            continue;
                        }
                        char currentChar = currentString.charAt(coll);
                        matrix[row + row2][lastColl] = currentChar;
                        row2++;
                    }
                    coll2++;
                }
                printMatrix(matrix);
            } else if (intRotation == 270) {
                int coll2 = 0;
                for (int row = 0; row < matrix[row].length; row++) {
                    int lastColl = matrix[row].length - 1;
                    String currentString = inputs.get(row);
                    for (int coll = 0; coll < matrixLength; coll++) {
                        if (coll > currentString.length() - 1) {
                            matrix[coll +lastColl][row] = ' ';
                            lastColl--;
                            continue;
                        }
                        char currentChar = currentString.charAt(coll);
                        matrix[coll2][coll + lastColl] = currentChar;
                        lastColl--;
                    }
                    coll2++;
                }
                printMatrix(matrix);
            }
        }

    }

    private static void printMatrix(Character[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
