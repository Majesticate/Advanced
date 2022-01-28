import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        List<Integer> listOfDivider = Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        List<Integer> numbersThatAreAvailable = new ArrayList<>();

        BiPredicate<Integer ,Integer> predicate = (integer, integer2) -> integer % integer2 != 0;

        int count = 1;
        while (count++ <= number){
            AtomicBoolean isAvailable = new AtomicBoolean(true);
            int finalCount = count;

            listOfDivider.forEach(el -> {
                if (finalCount % el != 0){
                    isAvailable.set(false);
                }
            });

            if (isAvailable.get()){
                numbersThatAreAvailable.add(count);
            }

        }
        numbersThatAreAvailable.forEach(e -> System.out.print(e + " "));
    }
}
