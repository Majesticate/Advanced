import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateForName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthOfNameNeedToBe = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> predicate = e -> e.length() <= lengthOfNameNeedToBe;

        Consumer<String> consumer = System.out::println;

        Arrays.stream(names).filter(predicate).forEach(consumer);
    }
}
