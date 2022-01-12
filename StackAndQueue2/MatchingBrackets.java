package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '('){
                stack.push(i);
            } else if (currentChar == ')') {
                int startPosition = stack.pop();
                System.out.println(input.substring(startPosition, i + 1));
            }
        }

    }
}
