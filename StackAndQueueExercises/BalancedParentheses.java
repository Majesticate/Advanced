package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] chars = scanner.nextLine().toCharArray();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isTrue = true;

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];

            switch (currentChar) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;

                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty() || stack.pop() != currentChar) {
                        isTrue = false;
                    }
                    break;

            }
            if (!isTrue){
                break;
            }

        }
        System.out.println(isTrue ? "YES" : "NO");

    }
}
