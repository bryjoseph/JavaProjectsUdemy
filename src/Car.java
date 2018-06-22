// access modifiers private, public, protected, package
public class Car extends Vehicle {

    // objects have two major characteristics of state and behavior

    // software objects store their state in fields

    // class or member variables AKA fields
    private int wheels;
    private int doors;
    private int gear;
    private boolean isManual;
    private int currentGear;

    public Car(String name, String size, int wheels, int doors, int gear, boolean isManual) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gear = gear;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public int getWheels() { return wheels; }

    public void setWheels(int wheels) { this.wheels = wheels; }

    public int getDoors() { return doors; }

    public void setDoors(int doors) { this.doors = doors; }

    public boolean isManual() { return isManual; }

    public void setManual(boolean manual) { isManual = manual; }

    public int getCurrentGear() { return currentGear; }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.setCurrentGear(): Changed to gear " + this.currentGear);
    }

    public void changeSpeed(int speed, int direction) {
        System.out.println("Car.changeSpeed(): Speed " + speed + " direction " + direction);
        move(speed, direction);
    }
}
