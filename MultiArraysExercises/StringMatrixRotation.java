package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] readFirstInput = scanner.nextLine().split("\\(");
        String numberInString = readFirstInput[1];
        String replace = numberInString.replace(")", "");
        int number = Integer.parseInt(replace);

        List<String> inputs = new ArrayList<>();

        String input = scanner.nextLine();

        int wordLength = Integer.MIN_VALUE;

        while (!input.equals("END")) {
            if (input.length() > wordLength) {
                wordLength = input.length();
            }
            inputs.add(input);
            input = scanner.nextLine();
        }

        int rows = inputs.size();
        int collum = wordLength;

        char[][] matrix = new char[rows][collum];
        char[][] matrix90 = new char[collum][rows];
        char[][] matrix180 = new char[rows][collum];
        char[][] matrix270 = new char[collum][rows];


        if (number % 360 == 0) {
            readNormalMatrix(inputs, matrix);
            printMatrix(matrix);
        } else if (number % 270 == 0 && number < 360) {
            readNotNormalMatrix(inputs, matrix270);
            reverseCollum(matrix270);
            printMatrix(matrix270);
        } else if (number % 180 == 0) {
            readNormalMatrix(inputs, matrix180);
            reverseRows(matrix180);
            reverseCollum(matrix180);
            printMatrix(matrix180);
        } else if (number % 90 == 0) {
            readNotNormalMatrix(inputs, matrix90);
            reverseRows(matrix90);
            printMatrix(matrix90);
        }


    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void reverseCollum(char[][] matrix180) {
        for (int i = 0; i < matrix180.length / 2; i++) {
            for (int j = 0; j < matrix180[i].length; j++) {
                char temp = matrix180[i][j];
                matrix180[i][j] = matrix180[matrix180.length - i - 1][j];
                matrix180[matrix180.length - i - 1][j] = temp;
            }
        }
    }

    private static void reverseRows(char[][] matrix180) {
        for (int j = 0; j < matrix180.length; j++) {
            for (int i = 0; i < matrix180[j].length / 2; i++) {
                char temp = matrix180[j][i];
                matrix180[j][i] = matrix180[j][matrix180[j].length - i - 1];
                matrix180[j][matrix180[j].length - i - 1] = temp;
            }
        }
    }

    private static void readNotNormalMatrix(List<String> inputs, char[][] matrix90) {
        for (int i = 0; i < inputs.size(); i++) {
            for (int j = 0; j < matrix90.length; j++) {
                char getChar = ' ';
                if (j <inputs.get(i).length()){
                    getChar = inputs.get(i).charAt(j);
                }
                matrix90[j][i] = getChar;
            }
        }
    }

    private static void readNormalMatrix(List<String> inputs, char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char getChar = ' ';
                if (j <inputs.get(i).length()){
                    getChar = inputs.get(i).charAt(j);
                }
                matrix[i][j] = getChar;
            }
        }
    }
}
