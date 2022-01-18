package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = nextInts(scanner);
        }

        int mainDiagonal = 0;
        int secondDiagonal = 0;

        for (int i = 0; i < matrix.length; i++) {
            mainDiagonal += matrix[i][i];
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int coll = matrix.length - 1- i; coll >= 0; coll--) {
                secondDiagonal += matrix[i][coll];
                break;
            }
        }
        System.out.println(Math.abs(mainDiagonal - secondDiagonal));
    }

    private static int[] nextInts(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
