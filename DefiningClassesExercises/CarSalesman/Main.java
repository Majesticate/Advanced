package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Engine> mapOfEngines = new HashMap<>();
        Map<String, Car> mapOfCars = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Engine currentEngine;
            if (tokens.length == 4) {
                currentEngine = new Engine(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]);
            } else if (tokens.length == 3) {
                if (isNumeric(tokens[2])) {
                    //if third par is number
                    currentEngine = new Engine(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                } else {
                    //if third par is not num
                    currentEngine = new Engine(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                }
            }else {
                currentEngine = new Engine(tokens[0],Integer.parseInt(tokens[1]));
            }
            mapOfEngines.put(currentEngine.getModel(), currentEngine);
        }

        n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Car currentCar;
            if (tokens.length == 4) {
                currentCar = new Car(tokens[0], mapOfEngines.get(tokens[1]), Integer.parseInt(tokens[2]), tokens[3]);
            } else if (tokens.length == 3) {
                if (isNumeric(tokens[2])) {
                    currentCar = new Car(tokens[0], mapOfEngines.get(tokens[1]), Integer.parseInt(tokens[2]));
                } else {
                    currentCar = new Car(tokens[0], mapOfEngines.get(tokens[1]), tokens[2]);
                }
            } else {
                currentCar = new Car(tokens[0], mapOfEngines.get(tokens[1]));
            }
            mapOfCars.put(tokens[0], currentCar);

        }


        mapOfCars.forEach((k, v) -> System.out.println(v));

    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
