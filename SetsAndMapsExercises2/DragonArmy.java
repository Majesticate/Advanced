import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int defaultHealth = 250;
        int defaultDmg = 45;
        int defaultArmor = 10;

        Map<String, Map<String, List<Integer>>> map = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String colorOfDragon = tokens[0];
            String nameOfDragon = tokens[1];
            int dmg = defaultDmg;
            int health = defaultHealth;
            int armor = defaultArmor;
            if (!tokens[2].equals("null")) {
                dmg = Integer.parseInt(tokens[2]);
            }
            if (!tokens[3].equals("null")) {
                health = Integer.parseInt(tokens[3]);
            }
            if (!tokens[4].equals("null")) {
                armor = Integer.parseInt(tokens[4]);
            }
            List<Integer> params = new ArrayList<>(List.of(dmg, health, armor));
            map.putIfAbsent(colorOfDragon, new TreeMap<>());
            map.get(colorOfDragon).put(nameOfDragon, new ArrayList<>());
            map.get(colorOfDragon).get(nameOfDragon).addAll(params);
        }

        map.entrySet().forEach(e -> {
            AtomicInteger dmg = new AtomicInteger();
            AtomicInteger hp = new AtomicInteger();
            AtomicInteger armor = new AtomicInteger();

            int size = e.getValue().size();

            e.getValue().forEach((k, v) -> {
                dmg.addAndGet(v.get(0));
                hp.addAndGet(v.get(1));
                armor.addAndGet(v.get(2));
            });
            double averageDmg = 1.0 * dmg.get() / size;
            double averageHp = 1.0 * hp.get() / size;
            double averageManna = 1.0 * armor.get() / size;
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",e.getKey(), averageDmg, averageHp, averageManna);
            e.getValue().entrySet().forEach((key) -> {
                List<Integer> values = key.getValue();
                int currentDmg = values.get(0);
                int currentHealth = values.get(1);
                int currentArmor = values.get(2);
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n" , key.getKey(), currentDmg, currentHealth, currentArmor);
            });
        });
    }
}
