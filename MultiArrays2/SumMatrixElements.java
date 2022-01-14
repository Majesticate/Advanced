package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[tokens[0]][tokens[1]];
        long sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] arrayInt = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < matrix[i].length; j++) {
                sum += arrayInt[j];
            }
        }
        System.out.println(tokens[0]);
        System.out.println(tokens[1]);
        System.out.println(sum);
    }
}
