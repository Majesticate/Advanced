import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterMode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();

        Map<String, Map<String, ArrayList<String>>> mapOfDeletedPeople = new HashMap<>();

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

        BiPredicate<String, String> containsPredicate = (name, toContain) -> name.contains(toContain);

        while (!input.equals("Print")) {
            String[] tokens = input.split(";");
            String doubleOrRemove = tokens[0];
            String command2 = tokens[1];
            String command3 = tokens[2];

            ArrayList<String> list = new ArrayList<>();

            if (command2.equals("Starts with")) {
                names.forEach(e -> {
                    List<String> apply = startWithFunction.apply(e, command3);
                    list.addAll(apply);
                });
            } else if (command2.equals("Ends With")) {
                names.forEach(e ->
                        endWithConsumer.accept(e, list));
            } else if (command2.equals("Length")) {
                int lengthOfName = Integer.parseInt(command3);
                names.forEach(e -> {
                    boolean ifIsTrue = equalFunc.apply(e, lengthOfName);
                    if (ifIsTrue) {
                        list.add(e);
                    }
                });
            } else if (command2.equals("Contains")) {
                ArrayList<String> collect = names.stream().filter(e -> containsPredicate.test(e, command3)).collect(Collectors.toCollection(ArrayList::new));
                list.addAll(collect);
            }


            if (doubleOrRemove.equals("Add filter")) {
                mapOfDeletedPeople.putIfAbsent(command2, new HashMap<>());
                Map<String, ArrayList<String>> put = mapOfDeletedPeople.put(command2, mapOfDeletedPeople.get(command2));
                put.putIfAbsent(command3, new ArrayList<>());
                put.put(command3, list);
                names.removeAll(list);
            } else {
                ArrayList<String> strings = mapOfDeletedPeople.get(command2).get(command3);
                mapOfDeletedPeople.remove(command2);
                names.addAll(strings);
            }
            input = scanner.nextLine();
        }

        if (!names.isEmpty()) {
            Collections.reverse(names);
            System.out.print(String.join(" ", names));
        }

    }
}