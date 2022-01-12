package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        ArrayDeque<String> stack = new ArrayDeque<>(input);

        while (stack.size() != 1){
            int number = Integer.parseInt(stack.pop());
            String command = stack.pop();
            int number2 = Integer.parseInt(stack.pop());
            if (command.equals("-")){
                stack.push(String.valueOf(number - number2));
            }else {
                stack.push(String.valueOf(number + number2));
            }

        }

        System.out.println(stack.peek());
    }
}
