package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCollums = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rowsAndCollums][rowsAndCollums];

        readMatrix(scanner, matrix);

        int firstDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            firstDiagonal = firstDiagonal + (matrix[i][i]);
        }

        int secondDiagonal = 0;
        int count = matrix.length -1;
        for (int i = 0; i < matrix.length; i++) {
            secondDiagonal = secondDiagonal + matrix[i][count];
            count--;
        }
        int sum = Math.abs(firstDiagonal - secondDiagonal);
        System.out.println(sum);

    }
    private static void readMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int[] arrayInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arrayInt;
        }
    }
}
