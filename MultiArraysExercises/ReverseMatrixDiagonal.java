package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCollums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        int rows = rowsAndCollums[0];
        int collums = rowsAndCollums[1];

        int[][] startMatrix = new int[rows][collums];

        int[][] secondMatrix = new int[rows + collums - 1][rows];

        int count = 0;

        for (int i = 0; i < startMatrix.length; i++) {
            startMatrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int collum = 0;
        int nextRo = 0;
        for (int row = startMatrix.length - 1; row >= 0; row--) {
            int ro = nextRo;
            for (int col = startMatrix[row].length - 1; col >= 0; col--) {
                secondMatrix[ro][collum] = startMatrix[row][col];
                ro++;
                if (col == count){
                    int currentRow = row;
                    for (int i = row-1; i >= 0; i--) {
                        secondMatrix[ro][collum] = startMatrix[i][col];
                        ro++;
                    }

                    break;
                }
            }
            collum++;
            nextRo++;
            count++;
        }
        for (int i = 0; i < secondMatrix.length; i++) {
            for (int j = 0; j < secondMatrix[i].length; j++) {
                if (secondMatrix[i][j] != 0) {
                    System.out.print(secondMatrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
