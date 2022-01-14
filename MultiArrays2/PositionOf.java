package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[tokens[0]][tokens[1]];

        boolean isFound = false;

        for (int i = 0; i < matrix.length; i++) {
            int[] theInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = theInput[j];
            }
        }

        int numberToFind = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == numberToFind){
                    System.out.printf("%d %d%n" , i , j);
                    isFound=true;
                }
            }
        }
        if (!isFound){
            System.out.println("not found");
        }
    }
}
