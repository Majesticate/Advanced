import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> nameDurations = new TreeMap<>();
        Map<String, TreeSet<String>> map = new TreeMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String ip = tokens[0];
            String name = tokens[1];
            int durations = Integer.parseInt(tokens[2]);

            nameDurations.putIfAbsent(name, 0);
            nameDurations.put(name, nameDurations.get(name) + durations);
            map.putIfAbsent(name, new TreeSet<>());
            map.get(name).add(ip);

        }
        nameDurations.forEach((k, v) -> {
            System.out.print(k + ": " + v + " ");
            System.out.print(map.get(k));
            System.out.println();
        });
    }
}
