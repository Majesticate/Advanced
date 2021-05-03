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
            String[] input = scanner.nextLine().split(" ");
            int command = Integer.parseInt(input[0]);

            switch (command){
                case 1:
                    String stringToAppend = input[1];
                    stringBuilder.append(stringToAppend);
                    stack.push(stringToAppend);
                    break;
                case 2:
                    int numbersToDelete = Integer.parseInt(input[1]);
                    for (int j = 0; j < numbersToDelete; j++) {
                        stringBuilder.deleteCharAt(stringBuilder.length() -1);
                    }
                    stack.push(stringBuilder.toString());
                    break;

                case 3:
                    int indexAt = Integer.parseInt(input[1]);
                    System.out.println(stringBuilder.charAt(indexAt -1));
                    break;
                case 4:
                    stack.pop();
                    stringBuilder.delete(0 , stringBuilder.length());
                    stringBuilder.append(stack.peek());
                    break;

            }

        }
    }
}
