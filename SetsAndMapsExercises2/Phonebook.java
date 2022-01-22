import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> map = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];
            map.put(name, number);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("stop")) {
            String name = input;
            if (map.containsKey(name)){
                System.out.println(name + " -> " + map.get(name));
            }else {
                System.out.printf("Contact %s does not exist.%n" , name);
            }
            input = scanner.nextLine();
        }

    }
}
