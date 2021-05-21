package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> map = new LinkedHashMap<>();

        int count = 0;
        String lastName = "";
        while (!input.equals("stop")) {
            count++;
            if (count % 2 == 1) {
                lastName = input;
                if (!map.containsKey(lastName)) {
                    map.put(input, 0);
                }
            } else {
                map.put(lastName, map.get(lastName) + Integer.parseInt(input));
            }

            input = scanner.nextLine();
        }
        map.forEach((k, v) -> {
            System.out.println(k + " -> " + v);
        });
    }
}
