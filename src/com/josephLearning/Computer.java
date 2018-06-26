package com.josephLearning;

public class Computer {

    private Case computerCase;
    private Monitor monitor;
    private MotherBoard motherBoard;

    public Computer(Case computerCase, Monitor monitor, MotherBoard motherBoard) {
        this.computerCase = computerCase;
        this.monitor = monitor;
        this.motherBoard = motherBoard;
    }

    public void powerOn() {
        // instead call property directly here
        computerCase.pressPowerButton();
        drawLogo();
    }
// showing example of old way of accessing getters
//    private Case getComputerCase() {
//        return computerCase;
//    }
//
//    private Monitor getMonitor() {
//        return monitor;
//    }
//
//    private MotherBoard getMotherBoard() {
//        return motherBoard;
//    }

    private void drawLogo() {
        // something to do with graphics
        monitor.drawPixelAt(1500, 1000, "yellow");
    }
}
