package com.company;

import java.util.*;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] symbol = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = symbol[0];
        int collum = symbol[1];

        int number = matrix[row][collum];
        int randomNum = 0;


        for (int i = 0; i < matrix.length; i++) {
            row = i;
            for (int j = 0; j < matrix[i].length; j++) {
                collum = j;
                randomNum++;
                if (matrix[i][j] == number) {
                    int myNum = getSum(matrix, row, collum, number);
                    map.put(randomNum, new ArrayList<>());
                    map.get(randomNum).add(i);
                    map.get(randomNum).add(j);
                    map.get(randomNum).add(myNum);

                }
            }
        }


        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            int rowPosition = integerListEntry.getValue().get(0);
            int collumPosition = integerListEntry.getValue().get(1);
            int numToChange = integerListEntry.getValue().get(2);
            matrix[rowPosition][collumPosition] = numToChange;
        }

        printMatrix(matrix);

    }

    private static int getSum(int[][] matrix, int row, int collum, int number) {
        int sum = 0;

        if (row >= 1) {
            if (matrix[row - 1][collum] != number) {
                sum += matrix[row - 1][collum];
            }
        }
        if (row < matrix.length - 1) {
            if (matrix[row + 1][collum] != number) {
                sum += matrix[row + 1][collum];
            }
        }
        if (collum >= 1) {
            if (matrix[row][collum - 1] != number) {
                sum += matrix[row][collum - 1];
            }
        }
        if (collum < matrix[row].length - 1) {
            if (matrix[row][collum + 1] != number) {
                sum += matrix[row][collum + 1];
            }
        }
        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
