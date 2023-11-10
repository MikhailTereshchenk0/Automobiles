package automobiles;

public class Test {
    static public void main(String[] args) {
        Engine engine = new Engine("2V",22);
        FuelTank fuelTank = new FuelTank("Modern Fuel Tank",50);
        Wheel[] wheels = new Wheel[4];
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new Wheel("A", 6.2);
        }
        Mercedes mercedes = new Mercedes("Yellow", engine, fuelTank, wheels);

        System.out.println(mercedes.toString());
        System.out.println(mercedes.getColor());
        System.out.println(mercedes.getEngine());
        System.out.println(mercedes.getFuelTank());

        mercedes.ride(6.5);
        mercedes.refuel(48);
        mercedes.ride(6.5);
        System.out.println(mercedes.getFuelAmount());
        mercedes.refuel(10);
        mercedes.ride(150);
        System.out.println(mercedes.getFuelAmount());
        mercedes.changeWheel(new Wheel("B", 6.1), 3);
        mercedes.ride(2);
        System.out.println(mercedes.getMileage());
        System.out.println(mercedes.toString());
    }
}
