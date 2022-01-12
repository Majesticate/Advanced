package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> children = new ArrayDeque<>(Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList()));

        int n = Integer.parseInt(scanner.nextLine());

        while (children.size() != 1){
            for (int i = 1; i < n; i++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }
            String childToRemove = children.poll();
            System.out.println("Removed " + childToRemove);
        }
        System.out.printf("Last is %s" , children.peek());
    }
}
