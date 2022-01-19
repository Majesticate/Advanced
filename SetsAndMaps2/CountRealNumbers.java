import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());

        Map<Double , Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < numbers.size(); i++) {
            map.putIfAbsent(numbers.get(i), 0);
            map.put(numbers.get(i), map.get(numbers.get(i)) + 1);
        }

        map.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
