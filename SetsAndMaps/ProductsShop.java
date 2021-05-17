package com.company;

import java.util.*;

public class ProductsShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , List<String>> map = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] inputToArray = input.split(", ");
            String nameOfShop = inputToArray[0];
            String nameOfProduct = inputToArray[1];
            String priceOfProduct = inputToArray[2];

            List<String> list = new ArrayList<>();
            list.add(nameOfProduct);
            list.add(priceOfProduct);
            if (map.containsKey(nameOfShop)){
                map.get(nameOfShop).add(list.get(0));
                map.get(nameOfShop).add(list.get(1));
            }

            map.putIfAbsent(nameOfShop , list);


            input = scanner.nextLine();
        }
        map.forEach((k ,v) -> {
            System.out.println(k + "->");
            for (int i = 0; i <= v.size() / 2; i++) {
                System.out.printf("Product: %s, Price: %.1f%n" ,v.get(i) , Double.parseDouble(v.get(i +1)));
                i++;
            }
        });
    }
}
