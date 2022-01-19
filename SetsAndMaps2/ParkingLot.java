import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> set = new LinkedHashSet<>();

        while (!input.equals("END")){
            String[] tokens = input.split(", ");
            String command = tokens[0];
            String carNumber = tokens[1];
            if (command.equals("IN")){
                set.add(carNumber);
            }else {
                set.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        String output = set.isEmpty() ? "Parking Lot is Empty" :
                                    String.join(System.lineSeparator() , set);
        System.out.println(output);
    }
}
