package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCollums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = rowsAndCollums[0];
        int collums = rowsAndCollums[1];

        String[][] matrix = new String[rows][collums];

        int number = 0;
        for (int i = 97; i < i + matrix.length; i++) {

            for (int j = 0; j < matrix[number].length; j++) {
                StringBuilder stringBuilder = new StringBuilder();
                char firstChar = (char) i;
                char secondChar = (char) (j + i);
                char thirdChar = (char) i;
                stringBuilder.append(firstChar).append(secondChar).append(thirdChar);
                matrix[number][j] = stringBuilder.toString();
            }
            number++;
            if (number == rows){
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}
