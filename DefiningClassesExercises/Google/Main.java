package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Person> map = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            String command = tokens[1];
            String nameOfCommand = tokens[2];
            String secondNameOfCommand = tokens[3];

            map.putIfAbsent(name, new Person(name));

            Person currentPerson = map.get(name);
            switch (command) {
                case "company":
                    Company company = new Company(nameOfCommand, secondNameOfCommand, Double.parseDouble(tokens[4]));
                    map.get(name).setCompany(company);
                    break;
                case "car":
                    Car car = new Car(nameOfCommand, Integer.parseInt(secondNameOfCommand));
                    if (currentPerson.getCar() == null) {
                        currentPerson.setCar(car);
                    }
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(nameOfCommand, secondNameOfCommand);
                    currentPerson.getPokemonList().add(pokemon);
                    break;
                case "children":
                    Children children = new Children(nameOfCommand, secondNameOfCommand);
                    currentPerson.getChildrenList().add(children);
                    break;
                case "parents":
                    Parent parent = new Parent(nameOfCommand, secondNameOfCommand);
                    currentPerson.getParentsList().add(parent);
                    break;
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        Person personToPrint = map.get(input);

        String outputForCompany = personToPrint.getCompany() == null ? "" : String.valueOf(personToPrint.getCompany());

        System.out.printf("%s%nCompany:%s%nCar:%s", personToPrint.getName(), outputForCompany, personToPrint.getCar());
        personToPrint.printAllPokemon(personToPrint.getPokemonList());
        personToPrint.printAllParents(personToPrint.getParentsList());
        personToPrint.printAllChildren(personToPrint.getChildrenList());
    }
}
