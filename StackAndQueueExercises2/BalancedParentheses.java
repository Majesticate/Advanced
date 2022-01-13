package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < input.length() /2; i++) {
            queue.push(input.charAt(i));
        }

        int size = queue.size();
        boolean isFound = false;

        for (int i = size; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char lastCharInQueue = queue.pop();
            if (currentChar == ')' && lastCharInQueue != '(' || currentChar == ']' && lastCharInQueue != '[' || currentChar == '}' && lastCharInQueue != '{'){
                isFound = true;
                break;
            }
        }
        System.out.println(isFound ? "NO" : "YES");
    }
}
