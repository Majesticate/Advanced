package com.company;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] arrayDouble = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        Map<Double , Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < arrayDouble.length; i++) {
            map.putIfAbsent(arrayDouble[i],0);
            map.put(arrayDouble[i],map.get(arrayDouble[i]) +1);
        }
        map.forEach(((k, v) -> System.out.printf("%.1f -> %d%n", k ,v)));
    }
}
