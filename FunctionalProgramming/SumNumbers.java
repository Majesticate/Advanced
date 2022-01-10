package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list =
                Arrays.stream(scanner.nextLine().split(", "))
                        .collect(Collectors.toList());

        Function<List<String>, Integer> count = List::size;
        Function<List<String>, Integer> sum = e -> list.stream().mapToInt(Integer::parseInt).sum();

        System.out.println("Count = " + count.apply(list));
        System.out.println("Sum = " + sum.apply(list));

    }
}
