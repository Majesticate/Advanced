package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split(" ");

        for (int i = 0; i < input.length; i++) {

            if (!(i % 2 == 0)) {
                break;
            } else {
                int number = Integer.parseInt(input[i]);
                if (i == 0) {
                    stack.push(number);
                } else {
                    String previousIndex = input[i - 1];
                    if (previousIndex.equals("+")) {
                        int sumOfTwo = stack.peek() + number;
                        stack.push(sumOfTwo);
                    } else if (previousIndex.equals("-")) {
                        int sumOfTwo = stack.peek() - number;
                        stack.push(sumOfTwo);
                    }

                }
                if (i == input.length - 1) {
                    System.out.println(stack.peek());
                }

            }

        }

    }
}
