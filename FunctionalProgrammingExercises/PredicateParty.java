import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();

        BiConsumer<String, List<String>> endWithConsumer = (endText, list) -> {
            String textToStartWith = endText;
            String substringOfName = endText.substring(endText.length() - textToStartWith.length());
            if (substringOfName.equals(textToStartWith)) {
                list.add(endText);
            }
        };

        BiFunction<String, String, List<String>> startWithFunction = ((name, startWith) -> {
            List<String> strings = new ArrayList<>();
            String substringOfName = name.substring(0, startWith.length());
            if (substringOfName.equals(startWith)) {
                strings.add(name);
            }
            return List.copyOf(strings);
        });
        BiFunction<String, Integer, Boolean> equalFunc = (s, i) -> s.length() == i;


        while (!input.equals("Party!")) {
            String[] tokens = input.split("\\s+");
            String doubleOrRemove = tokens[0];
            String command2 = tokens[1];
            String command3 = tokens[2];

            List<String> list = new ArrayList<>();

            if ("StartsWith".equals(command2)) {
                names.forEach(e -> {
                    List<String> apply = startWithFunction.apply(e, command3);
                    list.addAll(apply);
                });
            } else if ("EndsWith".equals(command2)) {
                names.forEach(e ->
                        endWithConsumer.accept(e, list));
            } else if ("Length".equals(command2)) {
                int lengthOfName = Integer.parseInt(command3);
                names.forEach(e -> {
                    boolean ifIsTrue = equalFunc.apply(e, lengthOfName);
                    if (ifIsTrue) {
                        list.add(e);
                    }
                });
            }
            if (doubleOrRemove.equals("Double")) {
                names.addAll(list);
            } else {
                names.removeAll(list);
            }
            input = scanner.nextLine();
        }

        if (names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            Collections.sort(names);
            System.out.print(String.join(", " ,names));
            System.out.print(" are going to the party!");
        }
    }
}

