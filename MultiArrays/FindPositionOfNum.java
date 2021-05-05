package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class FindPositionOfNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isFound = false;

        int[] rowsAndCollums = readArray(scanner);

        int rows = rowsAndCollums[0];
        int collums = rowsAndCollums[1];

        int[][] matrix = new int[rows][collums];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }

        int magicNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == magicNumber){
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }

        if (!isFound){
            System.out.println("not found");
        }


    }
    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}