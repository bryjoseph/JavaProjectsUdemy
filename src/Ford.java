public class Ford extends Car {

    private int roadService;

    public Ford(int roadService) {
        //to simplify, hardcode the Ford values acting as if there is ONLY one type of Ford
        super("Ford", "4WD", 4, 4, 6, false);
        this.roadService = roadService;
    }

    // rate is the current speed the car is traveling
    public void changeSpeed(int rate) {
        // the rate can be positive or negative and this will include that number into the currentSpeec()
        int newSpeed = getCurrentSpeed() + rate;
        if(newSpeed == 0) {
            stop();
            changeGear(1);
        } else if (newSpeed > 0 && newSpeed <= 10) {
            changeGear(1);
        } else if (newSpeed > 11 && newSpeed <= 20) {
            changeGear(2);
        } else if (newSpeed > 21 && newSpeed <= 30) {
            changeGear(3);
        } else if (newSpeed > 31 && newSpeed <= 40) {
            changeGear(4);
        } else if (newSpeed > 41 && newSpeed <= 50) {
            changeGear(5);
        } else {
            changeGear(6);
        }

        if(newSpeed > 0) {
            changeSpeed(newSpeed, getCurrentDirection());
        }
    }
}
