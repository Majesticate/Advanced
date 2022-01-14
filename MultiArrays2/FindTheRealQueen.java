package com.company;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];

        for (int i = 0; i < 8; i++) {
            matrix[i] = readArray(scanner);
        }

        for (int i = 1; i < matrix.length-1; i++) {
            for (int j = 1; j < matrix[i].length-1; j++) {
                boolean isRealQueen = true;
                if (matrix[i][j].equals("q")) {
                    if (matrix[i + 1][j - 1].equals("q") || matrix[i - 1][j + 1].equals("q") || matrix[i + 1][j + 1].equals("q") || matrix[i - 1][j - 1].equals("q")) {
                        isRealQueen = false;
                        continue;
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[i][k].equals("q")) {
                            if (k == j) {
                                continue;
                            }
                            isRealQueen = false;
                        }
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        if (matrix[k][j].equals("q")) {
                            if (k == i) {
                                continue;
                            }
                            isRealQueen = false;
                        }
                    }
                    boolean isOutOfBound = false;
                    int count = 0;
                    for (int row = i + 1; row < matrix.length; row++) {
                        for (int coll = j + 1 + count; coll < matrix.length; coll++) {
                            if (matrix[row][coll].equals("q")) {
                                isRealQueen = false;
                            }
                            count++;
                            if (coll == matrix.length - 1) {
                                isOutOfBound = true;
                            }
                            break;
                        }
                        if (isOutOfBound) {
                            break;
                        }
                    }
                    count = 0;
                    isOutOfBound = false;
                    for (int row = i - 1; row >= 0; row--) {
                        for (int coll = j - 1 - count; coll < matrix.length; coll++) {
                            if (matrix[row][coll].equals("q")) {
                                isRealQueen = false;
                            }
                            count++;
                            if (coll == 0) {
                                isOutOfBound = true;
                            }
                            break;
                        }
                        if (isOutOfBound) {
                            break;
                        }
                    }
                    count = 0;
                    isOutOfBound = false;
                    for (int row = i - 1; row >= 0; row--) {
                        for (int coll = j + 1 + count; coll < matrix.length; coll++) {
                            if (matrix[row][coll].equals("q")) {
                                isRealQueen = false;
                            }
                            count++;
                            if (coll == matrix.length - 1) {
                                isOutOfBound = true;
                            }
                            break;
                        }
                        if (isOutOfBound) {
                            break;
                        }
                    }
                    count = 0;
                    isOutOfBound = false;
                    for (int row = i + 1; row < matrix.length; row++) {
                        for (int coll = j - 1 - count; coll >= 0; coll--) {
                            if (matrix[row][coll].equals("q")) {
                                isRealQueen = false;
                            }
                            count++;
                            if (coll == 0) {
                                isOutOfBound = true;
                            }
                            break;
                        }
                        if (isOutOfBound) {
                            break;
                        }
                    }
                    if (isRealQueen) {
                        System.out.printf("%d %d", i, j);
                        return;
                    }
                }
            }
        }

    }

    private static String[] readArray(Scanner scanner) {
        return scanner.nextLine().split("\\s+");
    }
}
