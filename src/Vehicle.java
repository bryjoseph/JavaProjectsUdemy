public class Vehicle {

    private String name;
    private String size;
    private int currentSpeed;
    private int currentDirection;

    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;
        this.currentSpeed = 0;
        this.currentDirection = 0;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public int getCurrentSpeed() { return currentSpeed; }

    public void setCurrentSpeed(int currentSpeed) { this.currentSpeed = currentSpeed; }

    public int getCurrentDirection() { return currentDirection; }

    public void setCurrentDirection(int currentDirection) { this.currentDirection = currentDirection; }

    public void steer(int direction) {
        this.currentDirection += direction;
        System.out.println("Vehicle.steer(): steering at " + currentDirection + " degrees.");
    }

    public void move(int speed, int direction) {
        this.currentSpeed = speed;
        this.currentDirection = direction;
        System.out.println("Vehicle.move(): moving at " + currentSpeed + " in direction " + currentDirection);
    }

    public void stop() {
        this.currentSpeed = 0;
    }
}
