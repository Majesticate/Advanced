import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //pear"
        //•	"flour"
        //•	"pork"
        //•	"olive

        char[] chars = scanner.nextLine().replaceAll(" ", "").toCharArray();
        char[] chars2 = scanner.nextLine().replaceAll(" ", "").toCharArray();

        Map<String, List<String>> map = new LinkedHashMap<>();
        map.put("pear", new ArrayList<>());
        map.put("flour", new ArrayList<>());
        map.put("pork", new ArrayList<>());
        map.put("olive", new ArrayList<>());

        int min = Integer.min(chars.length, chars2.length);
        //char char1 = chars.length > chars2.length ? chars[i] : chars2[i];
        //char char2 = chars.length > chars2.length ? chars2[chars2.length - 1 - i] : chars[chars.length - 1 - i];

        boolean firstIsLonger = chars.length > chars2.length;

        for (int i = 0; i < min; i++) {
            char char1 = chars[i];
            char char2 = chars2[chars2.length - 1 - i];
            for (Map.Entry<String, List<String>> currentMap : map.entrySet()) {
                if (currentMap.getKey().contains(String.valueOf(char1)) && !currentMap.getValue().contains(String.valueOf(char1))) {
                    currentMap.getValue().add(String.valueOf(char1));
                }
                if (currentMap.getKey().contains(String.valueOf(char2)) && !currentMap.getValue().contains(String.valueOf(char2))) {
                    currentMap.getValue().add(String.valueOf(char2));
                }
            }

        }

        if (firstIsLonger) {
            for (int i = min; i < chars.length - 1; i++) {
                char currentChar = chars[i];
                for (Map.Entry<String, List<String>> currentMap : map.entrySet()) {
                    if (currentMap.getKey().contains(String.valueOf(currentChar)) && !currentMap.getValue().contains(String.valueOf(currentChar))) {
                        currentMap.getValue().add(String.valueOf(currentChar));
                    }
                }
            }
        } else {
            int least = chars2.length - min;
            for (int i = least - 1; i >= 0; i--) {
                char currentChar = chars2[i];
                for (Map.Entry<String, List<String>> currentMap : map.entrySet()) {
                    if (currentMap.getKey().contains(String.valueOf(currentChar)) && !currentMap.getValue().contains(String.valueOf(currentChar))) {
                        currentMap.getValue().add(String.valueOf(currentChar));
                    }
                }
            }
        }

        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, List<String>> currentMap : map.entrySet()) {
            if (currentMap.getKey().length() == currentMap.getValue().size()) {
                stringBuilder.append(currentMap.getKey()).append("\n");
                count++;
            }
        }
        System.out.printf("Words found: %d%n", count);

        System.out.println(stringBuilder.toString());
    }
}
