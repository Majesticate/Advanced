package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Car car;
    private Company company;
    private List<Pokemon> pokemonList;
    private List<Children> childrenList;
    private List<Parent> parentsList;

    public Person(String name) {
        this.name = name;
        this.car = null;
        this.company = null;
        this.pokemonList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    public List<Parent> getParentsList() {
        return parentsList;
    }

    public void setParentsList(List<Parent> parentsList) {
        this.parentsList = parentsList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append("\n");
        stringBuilder.append("Company:").append("\n");
        if (company != null){
            stringBuilder.append(company).append("\n");
        }
        stringBuilder.append("Car:").append("\n");
        if (car != null){
            stringBuilder.append(car).append("\n");
        }
        stringBuilder.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemonList) {
            stringBuilder.append(pokemon).append("\n");;
        }

        stringBuilder.append("Parents:").append("\n");
        for (Parent parent : parentsList) {
            stringBuilder.append(parent).append("\n");;
        }
        stringBuilder.append("Children:").append("\n");
        for (Children children : childrenList) {
            stringBuilder.append(children).append("\n");;
        }
        return stringBuilder.toString();
    }


    //@Override
    /*public String toString() {
        //%nPokemon:%s%nParents:%s%nChildren:%s%n
        return String.format("%s%nCompany:%s%nCar:%s%n",
                this.name, this.company, this.car);
    }

     */

    public void printAllPokemon(List<Pokemon> pokemon) {
        System.out.println();
        System.out.println("Pokemon:");
        pokemon.forEach(e -> {
            System.out.println(e.getName() + " " + e.getElement());
        });
    }

    public void printAllParents (List<Parent> parents) {

        System.out.println("Parents:");
        parents.forEach(e -> {
            System.out.println(e.getName() + " " + e.getBirthday());
        });
    }
    public void printAllChildren (List<Children> children) {

        System.out.println("Children:");
        children.forEach(e -> {
            System.out.println(e.getName() + " " + e.getBirthday());
        });
    }

}
