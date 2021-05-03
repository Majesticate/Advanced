package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class BasicQueueOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        List<Integer> firstNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int repeats = firstNumbers.get(0);
        int numbersForRemove = firstNumbers.get(1);
        int specialNumber = firstNumbers.get(2);

        List<Integer> secondNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < repeats; i++) {
            queue.offer(secondNumbers.get(i));
        }

        for (int i = 0; i < numbersForRemove; i++) {
            queue.poll();
        }

        if (queue.isEmpty()){
            System.out.println(0);
            return;
        }

        if (queue.contains(specialNumber)){
            System.out.println(true);
        }else {
            Integer minNumber = Collections.min(queue);
            System.out.println(minNumber);
        }




    }
}
