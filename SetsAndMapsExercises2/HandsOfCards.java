import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String , Set<String>> map = new LinkedHashMap<>();
        Map<String , Integer> nameAndSumOfAllCards = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");
            map.putIfAbsent(name , new HashSet<>());
            nameAndSumOfAllCards.putIfAbsent(name , 0);
            for (int i = 0; i < cards.length; i++) {
                int multiple = 0;
                int numberOfCard = 0;
                String currentCard = cards[i];
                switch (currentCard.charAt(0)) {
                    case '1':
                        numberOfCard = 10;
                        String lastChar = Character.toString(currentCard.charAt(2));
                        currentCard = currentCard.replaceAll("0", lastChar);
                        break;
                    case 'A':
                        numberOfCard = 14;
                        break;
                    case 'J':
                        numberOfCard = 11;
                        break;
                    case 'Q':
                        numberOfCard = 12;
                        break;
                    case 'K':
                        numberOfCard = 13;
                        break;
                    default: numberOfCard = Integer.parseInt(String.valueOf(currentCard.charAt(0)));
                }
                switch (currentCard.charAt(1)){
                    case 'C':
                        multiple = 1;
                        break;
                    case 'D':
                        multiple = 2;
                        break;
                    case 'H':
                        multiple = 3;
                        break;
                    case 'S':
                        multiple = 4;
                        break;
                }
                Set<String> set = map.get(name);
                if (!set.contains(currentCard)) {
                    map.get(name).add(currentCard);
                    int sumOfNumber = multiple * numberOfCard;
                    nameAndSumOfAllCards.put(name, nameAndSumOfAllCards.get(name) + sumOfNumber);
                }

            }

            input = scanner.nextLine();
        }
        nameAndSumOfAllCards.forEach((k ,v) -> System.out.println(k + ": " + v));
    }
}
