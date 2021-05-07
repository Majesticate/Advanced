package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCollum = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndCollum[0];
        int collums = rowsAndCollum[1];

        String[][] matrix = new String[rows][collums];

        for (int i = 0; i < matrix.length; i++) {
            String[] array = scanner.nextLine().split("\\s+");
            matrix[i] = array;
        }
        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("END")) {
            if (input[0].equals("swap")) {
                if (Integer.parseInt(input[1]) < rows && Integer.parseInt(input[2]) < collums && Integer.parseInt(input[3]) < rows && Integer.parseInt(input[4]) < collums) {
                    int firstNum = Integer.parseInt(input[1]);
                    int secondNum = Integer.parseInt(input[2]);
                    int thirdNum = Integer.parseInt(input[3]);
                    int fourthNum = Integer.parseInt(input[4]);
                    String toReplace = matrix[firstNum][secondNum];
                    matrix[firstNum][secondNum] = matrix[thirdNum][fourthNum];
                    matrix[thirdNum][fourthNum] = toReplace;

                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            input =scanner.nextLine().split("\\s+");
        }
    }
}
