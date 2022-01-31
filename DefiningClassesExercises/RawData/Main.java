package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new TreeMap<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            Car newCar = new Car(tokens[0],Integer.parseInt(tokens[1]),Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[3]),tokens[4],
                    Double.parseDouble(tokens[5]), Integer.parseInt(tokens[6]),
                    Double.parseDouble(tokens[7]), Integer.parseInt(tokens[8]),
                    Double.parseDouble(tokens[9]), Integer.parseInt(tokens[10]),
                    Double.parseDouble(tokens[11]), Integer.parseInt(tokens[12]));
            cars.putIfAbsent(newCar.getModel() , newCar);
        }

        String typeOfCars = scanner.nextLine();


        ArrayList<Map.Entry<String, Car>> onlyRequiredTypeOfCars =
                cars.entrySet().stream().filter(e -> e.getValue().getCarType().equals(typeOfCars))
                        .collect(Collectors.toCollection(ArrayList::new));

        if (typeOfCars.equals("fragile")) {
            onlyRequiredTypeOfCars.forEach(e -> {
                List<Double> collect = e.getValue().getTyresPressure().stream().filter(v -> v < 1).collect(Collectors.toList());
                if (!collect.isEmpty()) {
                    System.out.println(e.getValue().getModel());
                }
            });
        }else {
            onlyRequiredTypeOfCars.forEach(e -> {
                if (e.getValue().getEnginePower() > 250){
                    System.out.println(e.getValue().getModel());
                }
            });
        }
    }
}
