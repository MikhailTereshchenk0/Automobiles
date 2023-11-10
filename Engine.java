package automobiles;

public class Engine {
    final private String type;
    final private double fuelConsumption;

    Engine(String type, double fuelConsumption) {
        this.type = type;
        this.fuelConsumption = fuelConsumption;
    }
    public String getType() {
        return type;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return "Engine: " + type + ".\nFuel consumption: " + fuelConsumption + ".\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Engine other = (Engine) obj;
        if (fuelConsumption != other.fuelConsumption) return false;
        if (type == null) {
            return other.type == null;
        }
        else return type.equals(other.type);
    }
}
