package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readRow(scanner);
        }

        int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = tokens[0];
        int coll = tokens[1];

        int sum = 0;

        if (row != 0) {
            sum += matrix[row - 1][coll];
        }
        if (row != matrix.length - 1) {
            sum += matrix[row + 1][coll];
        }
        if (coll != 0) {
            sum += matrix[row][coll - 1];
        }
        if (coll != matrix.length - 1) {
            sum += matrix[row][coll + 1];
        }
        matrix[row][coll] = sum;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private static int[] readRow(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
