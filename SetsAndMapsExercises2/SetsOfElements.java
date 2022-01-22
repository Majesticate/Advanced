import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayInt = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int firstSetLength = arrayInt[0];
        int secondSetLength = arrayInt[1];

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        while (firstSetLength-- > 0) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            firstSet.add(currentNum);
        }
        while (secondSetLength-- > 0) {
            int currentNum = Integer.parseInt(scanner.nextLine());
            secondSet.add(currentNum);
        }

        Set<Integer> repeatedNum = new LinkedHashSet<>();

        for (Integer integer : firstSet) {
            if (secondSet.contains(integer)) {
                repeatedNum.add(integer);
            }
        }
        repeatedNum.forEach(e -> System.out.print(e + " "));
    }
}
