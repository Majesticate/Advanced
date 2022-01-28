import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int divider = Integer.parseInt(scanner.nextLine());

        IntPredicate predicate = e -> e % divider != 0;

        int[] filteredNumbers = Arrays.stream(arrayInt).filter(predicate).toArray();

        List<Integer> list = Arrays.stream(filteredNumbers).boxed().collect(Collectors.toList());

        Collections.reverse(list);

        Consumer<Integer> print = e -> System.out.print(e + " ");

        list.forEach(print);

    }
}
