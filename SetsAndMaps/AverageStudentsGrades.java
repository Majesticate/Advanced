package com.company;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String , List<Double>> studentGrade = new TreeMap<>();
        Map<String , Integer> studentRepeats = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            studentRepeats.putIfAbsent(name , 0);

            studentGrade.putIfAbsent(name , new ArrayList<>());
            studentGrade.get(name).add(grade);

            studentRepeats.put(name , studentRepeats.get(name) + 1);

        }
        List<Double> list= new ArrayList<>();

        studentGrade.forEach((k ,v) -> {
            double number =0;
            for (int i = 0; i < v.size(); i++) {
                number += v.get(i);
            }
            list.add(number / v.size());
        });

        int count = 0;
        for (Map.Entry<String, List<Double>> entry : studentGrade.entrySet()) {
            String k = entry.getKey();
            List<Double> v = entry.getValue();
            System.out.print(k + " -> ");
            v.forEach(el -> System.out.printf("%.2f ", el));
            System.out.printf("(avg: %.2f)%n" ,list.get(count));
            count++;
        }

/*        if (!studentGrade.isEmpty()) {
            studentGrade
                    .entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                    .forEach(pair -> {
                        System.out.println(pair.getKey());
                        pair.getValue().forEach(el -> System.out.printf(" - %s%n", el));
                    });
        }

 */
    }
}

