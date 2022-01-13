package com.company;

import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int[] arrayInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            list.add(arrayInt[i]);
        }
        int day = 0;
        int countDays = 0;
        boolean isLastDay = false;

        while (day == 0) {
            List<Integer> integersToDelete = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                int lastIndex = list.get(i);
                int indexBeforeLastIndex = list.get(i + 1);
                if (lastIndex < indexBeforeLastIndex) {
                    integersToDelete.add(list.get(i + 1));
                }
            }
            if (integersToDelete.isEmpty()){
                isLastDay = true;
                break;
            }

            for (int i = 0; i < integersToDelete.size(); i++) {
                list.remove(integersToDelete.get(i));
            }
            countDays++;
        }
        System.out.println(countDays);
    }
}
