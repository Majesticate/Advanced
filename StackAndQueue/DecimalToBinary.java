package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (input != 0) {
            stack.push(input % 2);
            input /= 2;
        }
        for (Integer integer : stack) {
            System.out.print(stack.pop());
        }

    }
}
