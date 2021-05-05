package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        int[] rowsAndCollums = readArray(scanner);
        int rows = rowsAndCollums[0];
        int collums = rowsAndCollums[1];

        int[][] matrix = new int[rows][collums];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readArray(scanner);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
               sum += matrix[i][j];
            }
        }
        System.out.println(rows);
        System.out.println(collums);
        System.out.println(sum);

    }
    private static int[] readArray (Scanner scanner){
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    }
}
