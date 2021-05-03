package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int[] arrayInt = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            switch (arrayInt[0]) {
                case 1:
                    int numberToPush = arrayInt[1];
                    stack.push(numberToPush);
                    break;
                case 2:
                    if (!stack.isEmpty()){
                        stack.pop();
                    }

                    break;
                case 3:
                    int maxNumber = Collections.max(stack);
                    if (!stack.isEmpty()){
                        System.out.println(maxNumber);
                    }

                    break;


            }
        }
    }
}
