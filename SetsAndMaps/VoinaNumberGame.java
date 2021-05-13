package com.company;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondArrayInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> firstHand = new LinkedHashSet<>();
        Set<Integer> secondHand = new LinkedHashSet<>();
        for (int j : arrayInt) {
            firstHand.add(j);
        }
        for (int i = 0; i < secondArrayInt.length; i++) {
            secondHand.add(secondArrayInt[i]);
        }

        boolean round50 = false;
        int countRounds = 0;

        while (!firstHand.isEmpty() || !secondHand.isEmpty()){
            int currentNumberForFirstHand = firstHand.iterator().next();
            int currentNumberForSecondHand = secondHand.iterator().next();
            firstHand.remove(firstHand.iterator().next());
            secondHand.remove(secondHand.iterator().next());
            if (currentNumberForFirstHand > currentNumberForSecondHand){
                addLastNumbers(firstHand, currentNumberForFirstHand, currentNumberForSecondHand);
            }else {
                addLastNumbers(secondHand, currentNumberForSecondHand, currentNumberForFirstHand);
            }
            countRounds++;
            if (countRounds == 50){
                round50 = true;
                break;
            }

        }
        if (firstHand.isEmpty() || secondHand.size() > firstHand.size()){
            System.out.println("Second player win!");
        }else if (firstHand.size() == secondHand.size()){
            System.out.println("Draw!");
        } else {
            System.out.println("First player win!");
        }

    }

    private static void addLastNumbers(Set<Integer> firstHand, int currentNumberForFirstHand, int currentNumberForSecondHand) {
        firstHand.add(currentNumberForFirstHand);
        firstHand.add(currentNumberForSecondHand);
    }
}
