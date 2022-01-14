package com.company;

import java.util.Scanner;

public class IntersectionOfTwoMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int coll = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[row][coll];
        String[][] secondMatrix = new String[row][coll];

        for (int i = 0; i < firstMatrix.length; i++) {
            String[] massive = readArray(scanner);
            for (int j = 0; j < firstMatrix[i].length; j++) {
                firstMatrix[i][j] = massive[j];
            }
        }

        for (int i = 0; i < secondMatrix.length; i++) {
            String[] massive = readArray(scanner);
            for (int j = 0; j < secondMatrix[i].length; j++) {
                if (massive[j].equals(firstMatrix[i][j])){
                    System.out.print(secondMatrix[i][j] = massive[j]+" ");
                }else {
                    System.out.print(secondMatrix[i][j] = "* ");
                }
            }
            System.out.printf("%n");
        }
    }

    private static String[] readArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
