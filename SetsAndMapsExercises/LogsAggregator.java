package com.company;

import java.util.Scanner;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String ip = input[0];
            String name = input[1];
            int duration = Integer.parseInt(input[2]);




        }
    }
}
