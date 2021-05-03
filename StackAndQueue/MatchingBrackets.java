package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();


        for (int i = 0; i < input.length(); i++) {
            char index = input.charAt(i);

            if (index == '('){
                stack.push(i);

            }else if (index == ')'){
                System.out.println(input.substring(stack.pop() , i + 1));
            }


        }
    }
}
