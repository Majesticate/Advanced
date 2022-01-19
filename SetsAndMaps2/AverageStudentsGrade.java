package com.company;

import java.util.*;

public class AverageStudentsGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<Double>> peoples = new TreeMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            peoples.putIfAbsent(name, new ArrayList<>());
            peoples.get(name).add(grade);
        }
        if (!peoples.isEmpty()) {
            peoples.forEach((k, v) -> {
                System.out.print(k + " -> ");
                v.forEach(e -> System.out.printf("%.2f ", e));
                double average = v.stream().mapToDouble(e -> e).average().getAsDouble();
                System.out.printf("(avg: %.2f)%n", average);
            });
        }


        /*
        for (Map.Entry<String, ArrayList<Double>> entry : peoples.entrySet()) {
            String k = entry.getKey();
            List<Double> v = entry.getValue();
            System.out.print(k + " -> ");
            v.forEach(el -> System.out.printf("%.2f ", el));
            double average = v.stream().mapToDouble(e -> e).average().getAsDouble();
            System.out.printf("(avg: %.2f)%n" ,average);
        }

         */
    }
}
