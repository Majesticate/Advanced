package com.company;

import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Long>> map = new TreeMap<>();

        while (!input.equals("report")) {
            String[] inputMassive = input.split("\\|");
            String city = inputMassive[0];
            String country = inputMassive[1];
            long population = Long.parseLong(inputMassive[2]);

            map.putIfAbsent(country, new LinkedHashMap<>());
            map.get(country).putIfAbsent(city, population);
            input = scanner.nextLine();
        }

        map.entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    long p1 = c1.getValue().values().stream().mapToLong(Long::longValue).sum();
                    long p2 = c2.getValue().values().stream().mapToLong(Long::longValue).sum();
                    return Long.compare(p2, p1);
                }).forEach(e -> {
            long population = e.getValue().values().stream().mapToLong(Long::longValue).sum();
            System.out.printf("%s (total population: %d)%n", e.getKey(), population);
            Map<String, Long> value = e.getValue();
            for (Map.Entry<String, Long> stringLongEntry : value.entrySet()) {
                System.out.printf("=>%s: %d%n" , stringLongEntry.getKey() , stringLongEntry.getValue());
            }
        });

        System.out.println();

    }
}