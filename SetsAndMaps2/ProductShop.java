import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String , Double>> map = new TreeMap<>();

        while (!input.equals("Revision")){
            String[] tokens = input.split(", ");
            String companyName = tokens[0];
            String productName = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            map.putIfAbsent(companyName , new LinkedHashMap<>());
            map.get(companyName).put(productName ,price);

            input = scanner.nextLine();
        }

        map.forEach((k , v) -> {
            System.out.printf(k + "->%n");
            v.forEach((prod , price) -> {
                System.out.printf("Product: %s, Price: %.1f%n" , prod , price);
            });
        });
    }
}
