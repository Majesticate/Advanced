package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int repeats = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < repeats; i++) {
            int[] operations = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            if (operations[0] == 1) {
                numbers.push(operations[1]);
            } else if (operations[0] == 2) {
                numbers.poll();
            } else if (operations[0] == 3) {
                System.out.println(numbers.stream().mapToInt(e -> e).max().getAsInt());
            }
        }
    }
}
