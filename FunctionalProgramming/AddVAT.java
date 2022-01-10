package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        List<Double> integersInput = input.stream().map(Double::parseDouble).collect(Collectors.toList());

        UnaryOperator<Double> addVat = e -> e * 1.20;

        List<Double> addedVat = integersInput.stream().mapToDouble(addVat::apply).boxed().collect(Collectors.toList());

        System.out.println("Prices with VAT:");
        addedVat.forEach(e -> System.out.printf("%.2f%n" , e));

    }
}
