import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> addFunc = e -> Arrays.stream(e).map(el -> el +=1).toArray();
        Function<int[], int[]> subtractFunc = e -> Arrays.stream(e).map(el -> el -= 1).toArray();
        Function<int[], int[]> multiplyFunc = e -> Arrays.stream(e).map(el -> el * 2).toArray();

        Consumer<int[]> consumer = el -> Arrays.stream(el).forEach(System.out::println);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            if (input.equals("add")) {
                arrayInt = addFunc.apply(arrayInt);
            } else if (input.equals("multiply")) {
                arrayInt = multiplyFunc.apply(arrayInt);
            } else if (input.equals("subtract")) {
                arrayInt = subtractFunc.apply(arrayInt);
            } else if (input.equals("print")) {
                consumer.accept(arrayInt);
            }

            input = scanner.nextLine();
        }
    }
}
