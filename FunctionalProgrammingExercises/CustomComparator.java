import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Predicate<Integer> evenP = e -> Math.abs(e) % 2 == 0;
        Predicate<Integer> oddP = e -> Math.abs(e) % 2 == 1;

        Consumer<List<Integer>> print = e -> {
            e.forEach(element -> System.out.print(element + " "));
        };

        List<Integer> evenNumbers = numbers.stream().filter(evenP).collect(Collectors.toList());
        List<Integer> oddNumbers = numbers.stream().filter(oddP).collect(Collectors.toList());
        Collections.sort(evenNumbers);
        Collections.sort(oddNumbers);
        print.accept(evenNumbers);
        print.accept(oddNumbers);
    }
}
