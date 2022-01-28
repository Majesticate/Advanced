import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Function<Integer[], Integer> minNumOfArray = e -> Collections.min(Arrays.asList(e.clone()));

        Integer[] toIntegers = Arrays.stream(arrayInt).boxed().toArray(Integer[]::new);

        System.out.println(minNumOfArray.apply(toIntegers));

    }
}
