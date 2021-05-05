package com.company;


import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areNotEqual = firstMatrix.length != secondMatrix.length;

        if (!areNotEqual) {
            for (int row = 0; row < firstMatrix.length; row++) {
                int[] firstArr = firstMatrix[row];
                int[] secondArr = secondMatrix[row];
                areNotEqual = firstArr.length != secondArr.length;
                for (int col = 0; col < firstArr.length; col++) {
                    if (firstArr[col] != secondArr[col]) {
                        areNotEqual = true;
                        break;
                    }
                }
                if (areNotEqual) {
                    break;
                }


            }
        }
        System.out.println(areNotEqual ? "not equal" : "equal");

    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] firstRowsAndCols = readArray(scanner);

        int rows = firstRowsAndCols[0];
        int cols = firstRowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}

