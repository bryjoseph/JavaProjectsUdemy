package com.interfacesAndAbstractClasses;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Button printButton = new Button("Print");

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

//        Player broj = new Player("Broj", 100, 100);
//        System.out.println(broj.toString());
//
//        broj.setHitPoints(90);
//        System.out.println(broj.toString());
//
//        broj.setWeapon("Axe");
//        savedObject(broj);
//        loadObject(broj);
//
//        System.out.println(broj.toString());
//        // using an interface
//        ISavable werewolf = new Monster("Werewolf", 200, 200);
//        // typical approach
//        // Monster werewolf = new Monster("Werewolf", 200, 200);
//
//        System.out.println("Strength = " + ((Monster) werewolf).getStrength());
//        savedObject(werewolf);
//        loadObject(werewolf);

//        GearBox gearBox = new GearBox(5);
//        // to instantiate the inner class use GearBox first (afterwards changed Gear to a PRIVATE inner class)
//        // GearBox.Gear first = gearBox.new Gear(1, 12.3);
//        gearBox.addGear(1, 12.3);
//        gearBox.addGear(2, 10.6);
//        gearBox.addGear(3, 15.9);
//
//        gearBox.operateClutch(true);
//        gearBox.changeGear(1);
//        gearBox.operateClutch(false);
//        gearBox.changeGear(2);
//        // taking this route, the wheelSpeed method uses the getRatio method from Gear.
//        // However, that method is not available to call from GearBox (wheelSpeed) is available to use)
//        System.out.println(gearBox.wheelSpeed(3000));

        // CANNOT instantiate in the following ways
        // GearBox.Gear second = new GearBox.Gear(2, 15.31);
        // GearBox.Gear third = new gearBox.Gear(3, 17.81);
        // CANNOT instantiate in the following ways

        // accessing the method in Gear inside GearBox
//        System.out.println(first.driveSpeed(1000));

        //Example of a LOCAL CLASS (inside the main method)
//        class ClickListener implements Button.OnClickListener {
//            // constructor
//            public ClickListener() {
//                System.out.println("I have been attached");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println("The button " + title + " was clicked");
//            }
//        }
//        // the printButton is the static button at the top
//        // the new ClickListener is the local class we just created
//        printButton.setOnClickListener(new ClickListener());

        // example of an ANONYMOUS LOCAL CLASS (can only be used once (declare & instantiate together))
        printButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        });
        listen();
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

    public static void listen() {
        boolean quit = false;
        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    printButton.onClick();
                    break;
            }
        }
    }
}
