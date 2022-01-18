package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[arrayInt[0]][arrayInt[1]];

        int row = 0;
        int coll = 0;

        for (int i = 97; i < 97 + arrayInt[0]; i++) {
            int count = 0;
            for (int j = 97; j < 97 + arrayInt[1]; j++) {
                matrix[row][coll] = "";
                for (int k = 0; k < 3; k++) {
                    if (k == 1 && coll != 0) {
                        matrix[row][coll] += (char) (i + count);
                    } else {
                        matrix[row][coll] += (char) i;
                    }
                }
                count++;
                coll++;
            }
            coll = 0;
            row++;
        }
        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
