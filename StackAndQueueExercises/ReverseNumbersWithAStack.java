package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < list.size(); i++) {
            stack.push(list.get(i));
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }


    }
}
