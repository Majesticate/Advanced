package com.company;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();

        addNumbers(scanner, set1, arrayInt, 0);
        addNumbers(scanner, set2, arrayInt, 1);

        set1.forEach(integer -> {
            if (set2.contains(integer)){
                System.out.print(integer+ " ");
            }
        });
    }

    private static void addNumbers(Scanner scanner, Set<Integer> set1, int[] arrayInt, int i2) {
        for (int i = 0; i < arrayInt[i2]; i++) {
            set1.add(Integer.parseInt(scanner.nextLine()));
        }
    }
}
