import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , Map<String ,Integer>> populationByCountries = new HashMap<>();


        String input = scanner.nextLine();

        while (!input.equals("report")){
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);

            populationByCountries.putIfAbsent(country, new TreeMap<>());
            populationByCountries.get(country).putIfAbsent(city , 0);
            populationByCountries.get(country).put(city , populationByCountries.get(country).get(city) + population);

            input = scanner.nextLine();
        }

        populationByCountries.entrySet().stream().sorted((e1, e2) -> {
            Long totalPopulationFirst = populationByCountries.get(e1.getKey()).entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            Long totalPopulationSecond = populationByCountries.get(e2.getKey()).entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            return Long.compare(totalPopulationSecond, totalPopulationFirst);
        }).forEach(entry -> {
            System.out.print(entry.getKey() + " ");

            StringBuilder builder = new StringBuilder();

            AtomicReference<Long> totalPopulation = new AtomicReference<>((long) 0);

            populationByCountries.get(entry.getKey()).entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e -> {
                        builder.append(String.format("=>%s: %d%n", e.getKey(), e.getValue()));
                        totalPopulation.updateAndGet(v -> v + e.getValue());
                    });

            System.out.println(String.format("(total population: %s)", totalPopulation.toString()));
            System.out.print(builder.toString());
        });
    }
}
