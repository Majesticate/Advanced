package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximumSumOf2x2matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = getArrayInt(scanner);

        int[][] matrix = new int[tokens[0]][tokens[1]];

        List<Integer> lastRow = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int[] arrayInt = getArrayInt(scanner);
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = arrayInt[j];
            }

        }
    }

    private static int[] getArrayInt(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    }
}
