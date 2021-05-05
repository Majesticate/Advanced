package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int[][] rowsAndCollums = new int[num][num];


        for (int i = 0; i < num; i++) {
            rowsAndCollums[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < rowsAndCollums.length; i++) {
            System.out.print(rowsAndCollums[i][i]+ " ");
        }
        System.out.println();

        for (int i = 0; i < rowsAndCollums.length; i++) {
            System.out.print(rowsAndCollums[i][num-1]+ " ");
            num--;
        }


    }
}
