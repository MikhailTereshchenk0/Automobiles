package automobiles;

public class Wheel {
    final private String type;
    final private double diameter;

    Wheel(String type, double diameter) {
        this.type = type;
        this.diameter = diameter;
    }

    public String getType() {
        return type;
    }
    public double getDiameter() {
        return diameter;
    }

    @Override
    public String toString() {
        return "Wheel: " + type + ".\nDiameter: " + diameter + ".\n";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Wheel other = (Wheel) obj;
        if (diameter != other.diameter) return false;
        if (type == null) {
            return other.type == null;
        }
        else return type.equals(other.type);
    }
}