package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scanner.nextLine();

        if (input.equals("forward")){
            if (queue.isEmpty()){
                System.out.println("no next URLs");
            }
        }else if (input.equals("back")){

        }else {
            queue.offer(input);
        }

    }
}
