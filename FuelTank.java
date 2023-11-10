package automobiles;

public class FuelTank {
    final private String type;
    final private double capacity;
    private double fullness;

    FuelTank(String type, double capacity) {
        this.type = type;
        this.capacity = capacity;
        fullness = 0;
    }

    public String getType() {
        return type;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getFullness() {
        return fullness;
    }

    public double getFree() {
        return capacity - fullness;
    }

    public boolean isEmpty() {
        return fullness == 0;
    }

    public void refuel(double volume) {
        if (fullness + volume > this.capacity) {
            System.out.println("No free space for fuel.");
            return;
        }
        fullness += volume;
        System.out.println("Refueled. The amount of fuel is" + fullness + "l.");
    }

    public boolean consume(double volume) {
        if (volume > fullness) {
            System.out.println("Not enough fuel.");
            return false;
        }
        fullness -= volume;
        return true;
    }

    @Override
    public String toString() {
        return "Fuel tank: " + type + ".\nCapacity: " + capacity + ".\nFullness: " + fullness + ".\n";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FuelTank other = (FuelTank) obj;
        if (capacity != other.capacity) return false;
        if (type == null) {
            return other.type == null;
        }
        else return type.equals(other.type);
    }
}
