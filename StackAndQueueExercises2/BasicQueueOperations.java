package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] operations = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int numberToAdd = operations[0];
        int numberToDelete = operations[1];
        int checkForThisNumber = operations[2];

        for (int i = 0; i < numberToAdd; i++) {
            queue.offer(numbers[i]);
        }
        for (int i = 0; i < numberToDelete; i++) {
            queue.poll();
        }

        if (queue.contains(checkForThisNumber)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(new ArrayList<>(queue).stream().mapToInt(e -> e).min().getAsInt());
        }

    }
}