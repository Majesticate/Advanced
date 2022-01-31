package CarSalesman;

public class Engine {
    static String defaultString = "n/a";
    static int defaultInt = 0;

    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this(model,power,displacement,defaultString);
    }

    public Engine(String model, int power, String efficiency) {
        this(model,power,defaultInt,efficiency);
    }

    public Engine(String model, int power){
        this(model,power,defaultInt,defaultString);
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        return String.format("%s:%n" +
                "Power: %d%n" +
                "Displacement: %s%n" +
                "Efficiency: %s" ,this.getModel(), this.power, Car.toString(this.displacement), this.efficiency);
    }
}
