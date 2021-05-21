package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character , Integer> map = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            map.putIfAbsent(currentChar , 0);
            map.put(currentChar , map.get(currentChar) + 1);
        }
        map.forEach((k,v) -> {
            System.out.println(k + ": " + v + " time/s");
        });
    }
}