package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayInt = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        int[] filteredNumbers = Arrays.stream(arrayInt).filter(e -> e % 2 == 0).toArray();

        int[] sortedEvenNumbers = Arrays.stream(filteredNumbers).sorted().toArray();

        System.out.println(getCollect(filteredNumbers));
        System.out.println(getCollect(sortedEvenNumbers));
    }

    private static String getCollect(int[] sortedEvenNumbers) {
        return Arrays.stream(sortedEvenNumbers).boxed().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
