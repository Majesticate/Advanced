package com.company;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];


        for (int i = 0; i < 8; i++) {

            String stringBuilderToString = scanner.nextLine().replaceAll(" ", "");
            char[] charArray = stringBuilderToString.toCharArray();

            matrix[i] = charArray;
        }

        for (int i = 0; i < matrix.length; i++) {
            boolean thisIsNotQueen = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'q') {
                    // if current Symbol is for Queen
                    int queenOnThisHorizontal = 0;
                    //now we start with the checks
                    for (int k = 0; k < matrix[i].length; k++) {
                        // this for is for horizontal check
                        if (matrix[i][k] == 'q') {
                            queenOnThisHorizontal++;
                        }
                        if (queenOnThisHorizontal >= 2) {
                            thisIsNotQueen = true;
                            break;
                        }
                    }
                    if (thisIsNotQueen) {
                        break;
                    }
                    int queenOnThisVertical = 0;
                    for (int k = 0; k < matrix.length; k++) {
                        // this for is for vertical check
                        if (matrix[i][k] == 'q') {
                            queenOnThisVertical++;
                        }
                        if (queenOnThisVertical >= 2) {
                            thisIsNotQueen = true;
                            break;
                        }

                    }
                    if (thisIsNotQueen) {
                        break;
                    }


                }
            }
        }
        System.out.println();

    }
}
