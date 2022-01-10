package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> allWords = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> predicate = e -> Character.isUpperCase(e.charAt(0));

        List<String> upperCaseWords = allWords.stream()
                .map(String::valueOf)
                .filter(e -> predicate.test(e))
                .collect(Collectors.toList());

        System.out.println(upperCaseWords.size());
        System.out.println(String.join(System.lineSeparator() , upperCaseWords));

    }
}
