package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int repeats = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < repeats; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            switch (command) {
                case "1":
                    stringBuilder.append(input[1]);
                    stack.push(stringBuilder.toString());
                    break;
                case "2":
                    stringBuilder.delete(stringBuilder.length() - Integer.parseInt(input[1]),stringBuilder.length());
                    stack.push(stringBuilder.toString());
                    break;
                case "3":
                    System.out.println(stringBuilder.charAt(Integer.parseInt(input[1]) - 1));
                    break;
                case "4":
                    stack.pop();
                    stringBuilder.delete(0 , stringBuilder.length());
                    stringBuilder.append(stack.peek());
                    break;
            }

        }
    }
}
