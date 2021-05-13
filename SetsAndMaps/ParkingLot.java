package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new LinkedHashSet<>();

        String[] input = scanner.nextLine().split("\\s+");

        while (!input[0].equals("END")){

            String carNumber = input[1];

            if (input[0].equals("IN,")){
                cars.add(carNumber);
            }else if (input[0].equals("OUT,")){
                cars.remove(carNumber);
            }
            input = scanner.nextLine().split("\\s+");
        }
        if (!cars.isEmpty()){
            String collect = cars.stream().collect(Collectors.joining(System.lineSeparator()));
            System.out.println(collect);
        }else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
