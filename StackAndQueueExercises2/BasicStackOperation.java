package com.company;

import java.util.*;

public class BasicStackOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] operations = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int numberToAdd = operations[0];
        int numberToDelete = operations[1];
        int checkForThisNumber = operations[2];

        for (int i = 0; i < numberToAdd - numberToDelete; i++) {
            stack.push(numbers[i]);
        }

        if (stack.contains(checkForThisNumber)) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(new ArrayList<>(stack).stream().mapToInt(e -> e).min().getAsInt());
        }

    }
}
