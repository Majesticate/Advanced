package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class BasicStackOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int elementsOfSecondNumbers = firstNumbers.get(0);
        int elementsToRemove = firstNumbers.get(1);
        int specialNumber = firstNumbers.get(2);

        for (int i = 0; i < elementsOfSecondNumbers; i++) {
            stack.push(secondNumbers.get(i));
        }

        for (int i = 0; i < elementsToRemove; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (stack.contains(specialNumber)) {
            System.out.println("true");
        } else {
            int min = Collections.min(stack);
            System.out.println(min);
        }




    }
}
