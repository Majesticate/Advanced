package SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String , Car> map = new TreeMap<>();

        while (n-- > 0){
            String[] tokens = scanner.nextLine().split("\\s+");
            Car newCar = new Car(tokens[0],Integer.parseInt(tokens[1]),Double.parseDouble(tokens[2]));
            map.putIfAbsent(newCar.getModel(), newCar);
        }
        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String driveModel = tokens[1];
            int driveDistance = Integer.parseInt(tokens[2]);

            if (command.equals("Drive")){
                Car currentCar = map.get(driveModel);
                double needFuel = currentCar.drive(driveDistance);
                if (currentCar.getFuel() >= needFuel){
                    currentCar.setFuel(currentCar.getFuel() - needFuel);
                    currentCar.setDistanceTraveled(currentCar.getDistanceTraveled() + driveDistance);
                }else {
                    System.out.println("Insufficient fuel for the drive");
                }
            }

            input = scanner.nextLine();
        }

        map.forEach((key, value) -> System.out.println(value));
    }
}
