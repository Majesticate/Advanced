package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterByAge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> listOfPeople = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n > 0) {
            String[] tokens = scanner.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            listOfPeople.add(person);
            n--;
        }

        String olderOrYounger = scanner.nextLine();
        int theGivenAge = Integer.parseInt(scanner.nextLine());

        List<Person> older =
                listOfPeople.stream()
                        .filter(olderOrYounger.equals("older") ?
                                (e -> e.age >= theGivenAge)
                                : (e -> e.age <= theGivenAge))
                        .collect(Collectors.toList());


        String[] howToOutput = scanner.nextLine().split(" ");

        if (howToOutput.length == 2){
            older.forEach(e -> System.out.printf("%s - %d%n" , e.name , e.age));
        }
        if (howToOutput.length == 1){
            if (howToOutput[0].equals("name")){
                older.forEach(e -> System.out.println(e.name));
            }else {
                older.forEach(e -> System.out.println(e.age));
            }
        }

    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
