package CarConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> listOfCars = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Car newCar;
            if (tokens.length == 1) {
                newCar = new Car(tokens[0]);
            } else {
                newCar = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }
            listOfCars.add(newCar);
        }

        listOfCars.forEach(e ->e.carInfo());
    }
}
