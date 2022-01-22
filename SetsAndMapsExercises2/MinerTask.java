import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , Integer> map = new LinkedHashMap<>();


        String input = scanner.nextLine();

        while (!input.equals("stop")){
            String resource = input;
            int quantity = Integer.parseInt(scanner.nextLine());
            map.putIfAbsent(resource , 0);
            map.put(resource, map.get(resource) + quantity);
            input = scanner.nextLine();
        }
        map.forEach((k ,v) -> System.out.println(k + " -> " + v));
    }
}
