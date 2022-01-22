import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> legendaryItems = Set.of("shards", "fragments", "motes");

        Map<String, Integer> legendaryMap = new TreeMap<>();
        legendaryMap.put("shards" , 0);
        legendaryMap.put("fragments" , 0);
        legendaryMap.put("motes" , 0);
        Map<String, Integer> map = new TreeMap<>();

        boolean isFound = false;
        String legendaryItemAbove250 = "";

        while (scanner.hasNextLine()) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                int quantityOfCurrentElement = Integer.parseInt(tokens[i]);
                String nameOfElement = tokens[i + 1].toLowerCase();

                if (legendaryItems.contains(nameOfElement)) {
                    legendaryMap.put(nameOfElement, legendaryMap.get(nameOfElement) + quantityOfCurrentElement);
                    if (legendaryMap.get(nameOfElement) > 250) {
                        legendaryMap.put(nameOfElement, legendaryMap.get(nameOfElement) - 250);
                        legendaryItemAbove250 = nameOfElement;
                        isFound = true;
                    }
                } else {
                    map.putIfAbsent(nameOfElement, 0);
                    map.put(nameOfElement, map.get(nameOfElement) + quantityOfCurrentElement);
                }
                if (isFound){
                    break;
                }
            }
            if (isFound){
                break;
            }
        }
        switch (legendaryItemAbove250){
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }
        legendaryMap.entrySet().stream().sorted((e1, e2) -> {
            int valueOfFirst = e1.getValue();
            int valueOfSecond = e2.getValue();
            return Integer.compare(valueOfSecond, valueOfFirst);
        }).forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));

        map.forEach((k ,v) -> {
            System.out.println(k + ": " + v);
        });

    }
}
