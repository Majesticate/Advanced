package RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private int engineSpeed;
    private int enginePower;
    private int carWeight;
    private String carType;
    private List<Double> tyresPressure;
    private List<Integer> tyresAges;

    public Car(String model, int engineSpeed, int enginePower, int carWeight, String carType,
               double tyrePressure1, int tyreAge1,
               double tyrePressure2, int tyreAge2,
               double tyrePressure3, int tyreAge3,
               double tyrePressure4, int tyreAge4) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.carWeight = carWeight;
        this.carType = carType;
        tyresPressure = new ArrayList<>(List.of(tyrePressure1,tyrePressure2,tyrePressure3,tyrePressure4));
        tyresAges = new ArrayList<>(List.of(tyreAge1,tyreAge2,tyreAge3,tyreAge4));
    }

    public String getModel() {
        return model;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public int getCarWeight() {
        return carWeight;
    }

    public String getCarType() {
        return carType;
    }

    public List<Double> getTyresPressure() {
        return tyresPressure;
    }

    public List<Integer> getTyresAges() {
        return tyresAges;
    }
}
