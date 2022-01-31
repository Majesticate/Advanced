package PokemonTrainer;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<Trainer, List<Pokemon>>> trainers = new TreeMap<>();

        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String nameOfTrainer = tokens[0];
            String nameOfPokemon = tokens[1];
            String pokemonElement = tokens[2];
            int healthOfPokemon = Integer.parseInt(tokens[3]);

            Pokemon currentPokemon = new Pokemon(nameOfPokemon, pokemonElement, healthOfPokemon);
            Trainer currentTrainer = new Trainer(nameOfTrainer);

            trainers.putIfAbsent(nameOfTrainer, new LinkedHashMap<>());
            trainers.get(nameOfTrainer).putIfAbsent(currentTrainer, new ArrayList<>());

            trainers.get(nameOfTrainer).get(currentTrainer).add(currentPokemon);

            trainers.put(nameOfTrainer, trainers.get(nameOfTrainer));

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")) {
            String element = input;
            trainers.forEach((k, v) -> {
                v.forEach((tra, lis) -> {
                    List<Pokemon> listOfDeletedPokemons = new ArrayList<>();
                    lis.forEach(pok -> {
                        //filter(e -> e.getElement().equals(element))
                        List<Pokemon> listOfFilteredPokemons =
                                lis.stream().filter(e -> e.getElement()
                                        .equals(element)).collect(Collectors.toList());
                        AtomicBoolean isTrue = new AtomicBoolean(false);
                        lis.forEach(e -> {
                            if (e.getElement().equals(element)){
                                isTrue.set(true);
                            }
                        });
                        if (!isTrue.get()) {
                            pok.healthRemain();
                            if (pok.getHealth() <= 0) {
                                listOfDeletedPokemons.add(pok);
                            }
                        }else {
                            tra.setBadges(tra.getBadges() + 1);
                        }
                    });
                    lis.removeAll(listOfDeletedPokemons);

                });

            });

            input = scanner.nextLine();
        }
        System.out.println();
        // trainers.forEach((k,v) -> v.forEach((tra, pok) -> System.out.printf("%s %d %d%n", tra.getName() , tra.getBadges() ,pok.size())));

        Map<String, List<Integer>> map = new TreeMap<>();

        trainers.entrySet().forEach(e -> {
            AtomicInteger badges = new AtomicInteger();
            e.getValue().forEach((trainer, pokemons) -> {
                badges.addAndGet(trainer.getBadges());
            });
            e.getValue().forEach((key1, value) -> {
                map.putIfAbsent(key1.getName(), new ArrayList<>());
                if (map.get(key1.getName()).isEmpty()) {
                    map.put(key1.getName(), new ArrayList<>());
                    List<Integer> bad = List.of(Integer.parseInt(String.valueOf(badges)), map.size());
                    List<Integer> put = map.put(key1.getName(), map.get(key1.getName()));
                    put.addAll(bad);
                }
            });
        });

        System.out.println();

    }
}
