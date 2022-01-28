import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String> addIngSirToName = e -> System.out.println("Sir " + e);

        Arrays.stream(names).forEach(addIngSirToName);
    }
}
