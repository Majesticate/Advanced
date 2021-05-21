package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> map = new LinkedHashMap<>();

        int count = 0;
        String lastName = "";
        while (!input.equals("stop")) {
            count++;
            if (count % 2 == 1) {
                lastName = input;
                if (!map.containsKey(lastName)) {
                    map.put(input, "");
                }
            } else {
                map.put(lastName, input);
                if (map.get(lastName).contains(".com") || map.get(lastName).contains(".us") || map.get(lastName).contains(".uk")){
                    map.remove(lastName);
                }
            }

            input = scanner.nextLine();
        }
        map.forEach((k,v) -> System.out.println(k + " -> " + v));

    }
}
