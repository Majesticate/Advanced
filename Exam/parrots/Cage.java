package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public int getCapacity(){
        return capacity;
    }

    public void add(Parrot parrot){
        if (data.size() < capacity){
            data.add(parrot);
        }
    }

    public boolean remove(String parrotName){
        for (Parrot parrot : data) {
            if (parrot.getName().equals(parrotName)){
                data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String parrotName){
        for (Parrot parrot : data) {
            if (parrot.getName().equals(parrotName)){
                parrot.setAvailable(false);
                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species){
        List<Parrot> newList = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)){
                newList.add(parrot);
            }
        }
        return newList;
    }

    public int count(){
        return data.size();
    }

    public String report(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parrots available at ").append(name).append(":").append("\n");
        for (Parrot parrot : data) {
            if (parrot.isAvailable()){
                stringBuilder.append(parrot).append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
