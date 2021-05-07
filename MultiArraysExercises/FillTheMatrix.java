package com.company;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(", ");
        int number = Integer.parseInt(strings[0]);
        String character = strings[1];


        int[][] matrixA = {
                {1, 5, 9, 13},
                {2, 6, 10, 14},
                {3, 7, 11, 15},
                {4, 8, 12, 16}
        };
        int[][] matrixB = {
                {1, 8, 9, 16},
                {2, 7, 10, 15},
                {3, 6, 11, 14},
                {4, 5, 12, 13}
        };


        if (character.equals("A")) {
            for (int num = 0; num < number; num++) {
                boolean isFound = false;

                boolean forJPluses = true;

                int count = 0;

                int maxCount = number * number;
                for (int i = 0; i < matrixA.length; i++) {
                    for (int j = 0; j < matrixA.length; j++) {
                        if (num >= 1 && forJPluses) {
                            j = j + num;
                        }
                        if (count == maxCount) {
                            isFound = true;
                            break;
                        }
                        if (count == 0 || count % number == 0) {
                            System.out.print(matrixA[j][i] + " ");
                        }
                        count++;
                        forJPluses = false;
                    }
                    if (isFound) {
                        break;
                    }
                }
                System.out.println();
            }

        } else if (character.equals("B")) {

        }

    }
}
