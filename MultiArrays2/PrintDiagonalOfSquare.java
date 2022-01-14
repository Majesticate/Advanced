package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalOfSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readRow(scanner);
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i]+" ");
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length-1-i; j >= 0; j--) {
                System.out.print(matrix[i][j]+" ");
                break;
            }
        }

    }

    private static int[] readRow(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
