package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.push(1);
        queue.push(1);
        if (n == 1){
            System.out.println(1);
            return;
        }else if (n == 2){
            System.out.println(2);
            return;
        }

        for (int i = 1; i < n; i++) {
            int lastItem = queue.pop();
            int itemBeforeLast = queue.peek();
            queue.push(lastItem);
            queue.push(lastItem + itemBeforeLast);
        }
        System.out.println(queue.peek());
    }
}
