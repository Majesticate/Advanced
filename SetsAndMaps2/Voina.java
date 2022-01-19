import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerStartCards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerStartCards = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());


        Set<Integer> firstPlayerCards = new LinkedHashSet<>(firstPlayerStartCards);
        Set<Integer> secondPlayerCards = new LinkedHashSet<>(secondPlayerStartCards);

        for (int i = 0; i < 50; i++) {
            if (firstPlayerCards.isEmpty()){
                System.out.println("Second player win!");
                return;
            }
            if (secondPlayerCards.isEmpty()){
                System.out.println("First player win!");
                return;
            }
            int firstNumber = firstPlayerCards.iterator().next();
            int secondNumber = secondPlayerCards.iterator().next();
            firstPlayerCards.remove(firstNumber);
            secondPlayerCards.remove(secondNumber);
            if (firstNumber > secondNumber){
                addNumbers(firstPlayerCards, firstNumber, secondNumber);
            }else if (secondNumber > firstNumber){
                addNumbers(secondPlayerCards, firstNumber, secondNumber);
            }
        }
        if (firstPlayerCards.size() > secondPlayerCards.size()){
            System.out.println("First player win!");
        }else if (secondPlayerCards.size() > firstPlayerCards.size()){
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw!");
        }


    }

    private static void addNumbers(Set<Integer> secondPlayerCards, int firstNumber, int secondNumber) {
        secondPlayerCards.add(firstNumber);
        secondPlayerCards.add(secondNumber);
    }
}
