package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int collums = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[rows][collums];
        for (int i = 0; i < firstMatrix.length; i++) {
            firstMatrix[i] = readArray(scanner);
        }
        String[][] secondMatrix = new String[rows][collums];
        for (int i = 0; i < secondMatrix.length; i++) {
            secondMatrix[i] = readArray(scanner);
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j].equals(secondMatrix[i][j])){
                    System.out.print(firstMatrix[i][j]+ " ");
                }else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }



    }
    private static String[] readArray(Scanner scanner) {
        return scanner.nextLine().split(" ");
    }
}
