package automobiles;

import java.util.Arrays;

public abstract class Automobile {

    final private String model;
    private String color;
    private Engine engine;
    private FuelTank fuelTank;
    private Wheel[] wheels;
    private double mileage;    //пробег
    Automobile(String model, String color, Engine engine, FuelTank fuelTank, Wheel[] wheels) {
        this.model = model;
        this.color = color;
        this.engine = engine;
        this.fuelTank = fuelTank;
        this.mileage = 0;
        this.wheels = wheels;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Engine getEngine() {
        return engine;
    }

    public double getMileage() {
        return mileage;
    }

    public void carModel() {
        System.out.println("Car model: " + model);
    }

    public void changeWheel(Wheel newWheel, int pos) {
        if (pos > wheels.length || pos < 0) {
            System.out.println("Can not to change the " + pos + " wheel.");
            return;
        }
        wheels[pos] = newWheel;
        System.out.println(pos + " wheel changed.");
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }
    public double getFuelAmount() {
        return fuelTank.getFullness();
    }

    //add wheels
    public void ride(double distance) {
        double requiredFuel = distance * engine.getFuelConsumption() / 100;    //необходимый объем топлива
        if (!fuelTank.consume(requiredFuel)) {
            return;
        }
        for (int pos = 1; pos < wheels.length; pos++) {
            if (wheels[0].getDiameter() != wheels[pos].getDiameter()) {
                System.out.println("The wheels has different diameters. Can not to ride.");
                return;
            }
        }
        mileage += distance;
        System.out.println("Drove " + distance + "km.");
    }

    public void refuel(double volume) {
        fuelTank.refuel(volume);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Car: " + model + ".\nColor: " + color + ".\n" + engine.toString() + fuelTank.toString());
        for (Wheel wheel : wheels) {
            str.append(wheel.toString());
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Automobile other = (Automobile) obj;
        if (model == null) {
            if (other.model != null)
                return false;
        }
        else if(!model.equals(other.model)) return false;
        if (color == null) {
            if (other.color != null)
                return false;
        }
        else if(!color.equals(other.color)) return false;
        if (engine == null) {
            if (other.engine != null)
                return false;
        }
        else if(!engine.equals(other.engine)) return false;
        if (fuelTank == null) {
            if (other.fuelTank != null)
                return false;
        }
        else if(!fuelTank.equals(other.fuelTank)) return false;
        if (wheels == null) {
            return other.wheels == null;
        }
        else return Arrays.equals(wheels, other.wheels);
    }
}
