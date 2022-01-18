package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayInt = getNextLine(scanner);

        int[][] matrix = new int[arrayInt[0]][arrayInt[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = getNextLine(scanner);
        }
        int maxSum = 0;
        List<Integer> list = new ArrayList<>();

        List<Integer> biggestNumbers = new ArrayList<>();
        int currentMaxNum = 0;
        for (int row = 0; row < arrayInt[0] - 2; row++) {
            for (int coll = 0; coll < arrayInt[1] - 2; coll++) {
                for (int i = row; i < 3 + row; i++) {
                    for (int j = coll; j < 3 + coll; j++) {
                        currentMaxNum += matrix[i][j];
                        list.add(matrix[i][j]);
                    }
                }
                if (currentMaxNum > maxSum) {
                    biggestNumbers.clear();
                    biggestNumbers.addAll(list);
                    maxSum = currentMaxNum;
                }
                list.clear();
                currentMaxNum = 0;
            }
        }

        System.out.println("Sum = " + maxSum);
        int nextNumbers = 0;
        for (int j = 0; j < 3; j++) {
            for (int i = nextNumbers; i < 3 + nextNumbers; i++) {
                System.out.printf("%d ", biggestNumbers.get(i));
            }
            nextNumbers += 3;
            System.out.println();
        }
    }

    private static int[] getNextLine(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
