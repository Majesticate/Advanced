package com.company;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(", ");
        int matrixLength = Integer.parseInt(input[0]);
        String modelOfMatrix = input[1];

        int[][] matrix = new int[matrixLength][matrixLength];
        int count = 1;

        if (modelOfMatrix.equals("A")) {
            for (int coll = 0; coll < matrixLength; coll++) {
                for (int row = 0; row < matrixLength; row++) {
                    matrix[row][coll] = count;
                    count++;
                }
            }
        }
        if (modelOfMatrix.equals("B")) {
            for (int coll = 0; coll < matrixLength; coll++) {
                if (coll % 2 == 0) {
                    for (int row = 0; row < matrixLength; row++) {
                        matrix[row][coll] = count;
                        count++;
                    }
                }
                if (coll % 2 == 1) {
                    for (int row = matrixLength - 1; row >= 0; row--) {
                        matrix[row][coll] = count;
                        count++;
                    }
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
