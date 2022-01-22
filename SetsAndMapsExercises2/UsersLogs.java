import java.util.*;

public class UsersLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String , Map<String , Integer>> map = new TreeMap<>();

        while (!input.equals("end")){
            String[] tokens = input.split("=");
            String[] ip2 = tokens[1].split(" ");
            String ip = ip2[0];
            String name = tokens[3];

            map.putIfAbsent(name , new LinkedHashMap<>());
            map.get(name).putIfAbsent(ip , 0);
            map.get(name).put(ip , map.get(name).get(ip) + 1);

            input = scanner.nextLine();
        }

        map.forEach((k, v) -> {
            System.out.println(k + ":");
            int count = 0;
            for (Map.Entry<String, Integer> entry : v.entrySet()) {
                String ke = entry.getKey();
                Integer vy = entry.getValue();
                System.out.print(ke + " => " + vy);
                count++;
                String output = count == v.size() ? "." : ",";
                System.out.printf("%s " , output);
            }
            System.out.println();
        });
    }
}
