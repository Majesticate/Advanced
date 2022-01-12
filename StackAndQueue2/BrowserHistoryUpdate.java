package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scanner.nextLine();

        String nextWebsite = "";
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    nextWebsite = stack.pop();
                    System.out.println(stack.peek());
                }
            } else if (input.equals("forward")) {
                if (nextWebsite.equals("")) {
                    System.out.println("no next URLs");
                } else {
                    stack.clear();
                    stack.push(nextWebsite);
                    nextWebsite = "";
                    System.out.println(stack.peek());
                }
            } else {
                stack.push(input);
                System.out.println(stack.peek());
            }

            input = scanner.nextLine();
        }
    }
}
