package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!input.equals("print")){

            if (input.equals("cancel")){
                if (!queue.isEmpty()){
                    System.out.printf("Canceled %s%n" , queue.poll());
                }else {
                    System.out.println("Printer is on standby");
                }
            }else {
                queue.offer(input);
            }
            input = scanner.nextLine();
        }

        for (String s : queue) {
            System.out.println(s);
        }
    }
}
