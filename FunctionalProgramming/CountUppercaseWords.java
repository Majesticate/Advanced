package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] allWords = scanner.nextLine().split("\\s+");

        List<String> uppercaseWords = Arrays.stream(allWords)
                .map(String::valueOf)
                .filter(e -> Character.isUpperCase(e.charAt(0)))
                .collect(Collectors.toList());


        System.out.println(uppercaseWords.size());
        printingAllUppercaseWords(uppercaseWords);
    }

    private static void printingAllUppercaseWords(List<String> upperCaseWords) {
        upperCaseWords.forEach(System.out::println);
    }
}
