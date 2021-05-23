package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Integer>> map = new TreeMap<>();


        while (!input.equals("end")) {
            String[] massive = input.split(" ");
            String ip = massive[0].substring(3);
            String userName = massive[2].substring(5);

            if (!map.containsKey(userName)) {
                map.put(userName, new LinkedHashMap<>());
                map.get(userName).put(ip, 1);
            } else if (!map.get(userName).containsKey(ip)) {
                map.get(userName).put(ip, 1);
            } else {
                map.get(userName).put(ip, map.get(userName).get(ip) + 1);
            }

            input = scanner.nextLine();
        }

        map.forEach((k, v) -> {
            System.out.println(k + ":");
            int repeats =0;
            for (Map.Entry<String, Integer> stringIntegerEntry : v.entrySet()) {
                System.out.print(stringIntegerEntry.getKey() + " => " +stringIntegerEntry.getValue());
                repeats++;
                if (repeats != v.size()){
                    System.out.print(", ");
                }else {
                    System.out.println(".");
                }
            }
        });
    }
}