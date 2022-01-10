package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] startEndNumbers =
                Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int start = startEndNumbers[0];
        int end = startEndNumbers[1];

        String command = scanner.nextLine();

        getCollect(start, end, command.equals("even")
                ? e -> e % 2 == 0
                : e -> e % 2 == 1);
    }

    private static void getCollect(int start, int end, Predicate<Integer> predicateForOdd) {
        IntStream.rangeClosed(start, end).filter(e -> predicateForOdd.test(e)).forEach(e -> System.out.printf(e + " "));
    }
}
