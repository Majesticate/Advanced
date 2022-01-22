import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            map.putIfAbsent(input.charAt(i) , 0);
            map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
        }

        map.forEach((k ,v) ->{
            System.out.printf("%c: %d time/s%n" , k ,v);
        });
    }
}
