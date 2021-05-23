package com.company;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> map = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] inputToArray = input.split(": |, ");
            String name = inputToArray[0];
            if (!map.containsKey(name)) {
                map.put(name, new LinkedHashSet<>());
            }
            for (int i = 1; i < inputToArray.length; i++) {
                map.get(name).add(inputToArray[i]);
            }
            input = scanner.nextLine();
        }

        Map<String , Integer> nameAndPoints = new LinkedHashMap<>();

        map.forEach((k, v) -> {
            int finalPoints = 0;
            for (String e : v) {
                int num;
                int multiply = 0;
                char firstChar = e.charAt(0);
                char secondChar = e.charAt(1);
                switch (firstChar) {
                    case 'J':
                        num = 11;
                        break;
                    case 'Q':
                        num = 12;
                        break;
                    case 'K':
                        num = 13;
                        break;
                    case 'A':
                        num = 14;
                        break;
                    default:
                        if (firstChar == '1') {
                            num = 10;
                            secondChar = e.charAt(2);
                        } else {
                            num = Character.getNumericValue(firstChar);
                        }
                }
                switch (secondChar) {
                    case 'S':
                        multiply = 4;
                        break;
                    case 'H':
                        multiply = 3;
                        break;
                    case 'D':
                        multiply = 2;
                        break;
                    case 'C':
                        multiply = 1;
                        break;
                }
                int result = num * multiply;
                finalPoints += result;
            }
            nameAndPoints.put(k , finalPoints);

        });

        nameAndPoints.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}