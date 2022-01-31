package Google;

public class Car {
    private String modelOfCar;
    private int hp;

    public Car(String modelOfCar, int hp) {
        this.modelOfCar = modelOfCar;
        this.hp = hp;
    }

    public String getModelOfCar() {
        return modelOfCar;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        //return this.modelOfCar == null ? "" : String.format("%n%s %d", this.modelOfCar , this.hp);
        return String.format("%s %d", this.modelOfCar , this.hp);
    }

}
