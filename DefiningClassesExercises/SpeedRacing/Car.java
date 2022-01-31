package SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double fuelCostForKm;
    private int distanceTraveled;

    public Car(String model, int fuel, double fuelCostForKm) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCostForKm = fuelCostForKm;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getFuelCostForKm() {
        return fuelCostForKm;
    }

    public void setFuelCostForKm(double fuelCostForKm) {
        this.fuelCostForKm = fuelCostForKm;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public double drive(int distance) {
        return this.fuelCostForKm * distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model , this.fuel , this.distanceTraveled);
    }
}
