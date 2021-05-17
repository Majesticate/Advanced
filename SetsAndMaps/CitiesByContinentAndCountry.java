package com.company;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, ArrayList<String>>> map = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!map.containsKey(continent)) {
                map.put(continent, new LinkedHashMap<>());
                map.get(continent).put(country, new ArrayList<>());
                map.get(continent).get(country).add(city);
            } else {
                if (!map.get(continent).containsKey(country)) {
                    map.get(continent).put(country, new ArrayList<>());
                    map.get(continent).get(country).add(city);
                } else {
                    map.get(continent).get(country).add(city);
                }
            }

        }

        map.forEach((key, value) -> {
            System.out.println(key + ": ");
            value.
                    forEach((k, v) -> {
                        System.out.printf(" %s -> %s%n", k, String.join(", ", v));
                    });
        });
    }
}