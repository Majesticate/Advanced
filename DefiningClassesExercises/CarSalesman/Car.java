package CarSalesman;

public class Car {
    static String defaultColor = "n/a";
    static int defaultWeight = 0;

    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, defaultColor);
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, defaultWeight, color);
    }

    public Car(String model, Engine engine) {
        this(model, engine, defaultWeight, defaultColor);
    }

    @Override
    public String toString() {
        return String.format("%s:%n%s%nWeight: %s%nColor: %s", this.model, this.engine, toString(this.weight), this.color);
    }

    public static String toString(int number) {
        if (number == 0) {
            return "n/a";
        }
        return String.valueOf(number);
    }


}
