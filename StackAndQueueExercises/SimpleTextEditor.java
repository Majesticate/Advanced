package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder stringBuilder = new StringBuilder();

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(input[0]);


            switch (command) {
                case 1:
                    String textToAppend = input[1];
                    stringBuilder.append(textToAppend);
                    stack.push(stringBuilder.toString());
                    break;

                case 2:
                    int elementsToDelete = Integer.parseInt(input[1]);
                    stringBuilder.delete(stringBuilder.length() - elementsToDelete, stringBuilder.length());
                    stack.push(stringBuilder.toString());
                    break;

                case 3:
                    int elementToPrint = Integer.parseInt(input[1]);
                    if (elementToPrint <= stringBuilder.length()) {
                        System.out.println(stringBuilder.charAt(elementToPrint - 1));
                    }
                    break;

                case 4:
                    stack.pop();
                    stringBuilder.delete(0, stringBuilder.length());
                    String nextString = stack.peek();
                    stringBuilder.append(nextString);
                    break;
            }


        }
    }
}
