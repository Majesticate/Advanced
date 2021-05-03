package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        int firstNumber = 1;

        stack.push(1);
        stack.push(1);

        if (n == 0){
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n -1; i++) {

            firstNumber = stack.peek();
            if (i == 0){
                stack.push( 2);
                list.add(2);
            }else {
                int previousNumber = list.get(list.size() -2);
                stack.push(firstNumber + previousNumber);
                list.add(stack.peek());
            }
        }
        System.out.println(stack.peek());
    }
}
