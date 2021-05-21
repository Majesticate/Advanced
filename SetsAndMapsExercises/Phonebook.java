package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , String> map = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("search")){
            String[] massive = input.split("-");
            String name = massive[0];
            String number = massive[1];

            map.put(name ,number);
            input = scanner.nextLine();
        }

        String searchName = scanner.nextLine();

        while (!searchName.equals("stop")){
            if (map.containsKey(searchName)){
                System.out.println(searchName + " -> " + map.get(searchName));
            }else {
                System.out.println("Contact " + searchName + " does not exist.");
            }


            searchName = scanner.nextLine();
        }
    }
}
