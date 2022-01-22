import java.util.*;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> set = new TreeSet<>();

        while (n-- > 0){
            String[] input = scanner.nextLine().split(" ");
            Collections.addAll(set, input);
        }
        System.out.println(String.join(" ", set));
    }
}
