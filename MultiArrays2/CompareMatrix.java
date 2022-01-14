package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] firstMatrix = new int[arrayInt[0]][arrayInt[1]];

        boolean isEqual = true;

        for (int i = 0; i < firstMatrix.length; i++) {
            int[] theInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < firstMatrix[i].length; j++) {
                firstMatrix[i][j] = theInput[j];
            }
        }
        int[] arrayInt2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] secondArray = new int[arrayInt2[0]][arrayInt2[1]];

        for (int i = 0; i < secondArray.length; i++) {
            int[] theInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < secondArray[i].length; j++) {
                secondArray[i][j] = theInput[j];
                if (firstMatrix[i][j] != secondArray[i][j]){
                    isEqual =false;
                    break;
                }
            }
        }

        if (isEqual){
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }

    }
}
