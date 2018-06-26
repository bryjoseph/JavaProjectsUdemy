package com.josephLearning;

public class Main {
    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(20, 20, 5);

        Case computerCase = new Case("ASUS", "ASUS", "240", dimensions);

        Monitor monitor = new Monitor("27 Inch Beast", "ACER", 27, new Resolution(2540, 1440));

        MotherBoard motherBoard = new MotherBoard("ASUSxTreme", "ASUS", 4, 4, "v2.4.4");

        Computer computer =  new Computer(computerCase, monitor, motherBoard);

        computer.powerOn();

        // accessing the drawPixelAt function living in the monitor class, via the computer object
//        computer.getMonitor().drawPixelAt(1500,1000, "red");
//        // same for motherBoard
//        computer.getMotherBoard().loadProgram("Oregon Trail");
//        // same for case
//        computer.getComputerCase().pressPowerButton();
    }
}
