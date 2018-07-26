package com.interfacesAndAbstractClasses;

import com.josephLearning.Monitor;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // because this is the interface NOT the class Office/Mobile can be used for new instances
//        ITelephone bryansPhone;
//        bryansPhone = new OfficePhone("721_301_5577");
//
//        bryansPhone.powerOn();
//        bryansPhone.dial("720_330_3322");
//        bryansPhone.callPhone("721_301_5577");
//        bryansPhone.answer();
//
//        bryansPhone = new MobilePhone("770_123_4567");
//        bryansPhone.powerOn();
//        bryansPhone.callPhone("721_098_7755");
//        bryansPhone.answer();

        Player broj = new Player("Broj", 100, 100);
        System.out.println(broj.toString());

        broj.setHitPoints(90);
        System.out.println(broj.toString());

        broj.setWeapon("Axe");
        savedObject(broj);
        loadObject(broj);

        System.out.println(broj.toString());
        // using an interface
        ISavable werewolf = new Monster("Werewolf", 200, 200);
        // typical approach
        // Monster werewolf = new Monster("Werewolf", 200, 200);

        System.out.println("Strength = " + ((Monster) werewolf).getStrength());
        savedObject(werewolf);
        loadObject(werewolf);


    }

    // this method is simulating a I/O program getting an actual file from storage. This just uses the console as a shortcut
    private static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose \n" +
                            "1 to enter a string\n" +
                            "0 to quit");
        while(!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter the string: ");
                    String enteredString = scanner.nextLine();
                    values.add(index, enteredString);
                    index++;
                    break;
            }
        }
        return values;
    }

    // this method takes the ISavable interface because ANY object using this interface can be saved, keeping it generic
    public static void savedObject(ISavable objectToSave) {
        for(int i = 0; i < objectToSave.write().size(); i++) {
            // this for loop saves the properties of the object (implementing the Savable interface)
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISavable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }
}
