package com.interfacesAndAbstractClasses.copyOfLinkedListCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LinkedList<Song> playList = new LinkedList<>();

        Album album1 = new Album("City of Evil", "Avenged Sevenfold");
        album1.addSong("Beast and the Harlot", 5.41);
        album1.addSong("Beast and the Harlot", 5.41);
        album1.addSong("Burn It Down", 5.00);
        album1.addSong("Blinded in Chains", 6.34);

        Album album2 = new Album("Load", "Metallica");
        album2.addSong("Aint my Bitch", 5.04);
        album2.addSong("2 X 4", 5.28);
        album2.addSong("The House That Jack Built", 6.39);

        Album album3 = Album.createAlbum("Wrath", "Lamb of God");
        //Album album3 = new Album("Wrath", "Lamb of God");
        album3.addSong("In Your Words", 5.24);
        album3.addSong("Set To Fail", 3.47);
        album3.addSong("Contractor", 3.22);

        if(album1.addSongToPlaylist(playList, 1)) {
            System.out.println("Song successfully added to play list");
        } else {
            System.out.println("Adding song to play list failed");
        }

        if(album2.addSongToPlaylist(playList, "Aint my Bitch")) {
            System.out.println("Song successfully added to play list");
        } else {
            System.out.println("Adding song to play list failed");
        }

        album3.addSongToPlaylist(playList, "In Your Words");

        playSongs(playList);

    }

    private static void printList(LinkedList<String> linkedList) {
        // is acting like a manually written for loop
        // an Iterator can not move forward and backward it only moves one direction through the list
        Iterator<String> i = linkedList.iterator();

        System.out.println("===============================");
        while(i.hasNext()) { // the check for while for a hasNext() value
            System.out.println("Now visiting: " + i.next()); // i.next() returns i AND performs i++
        }
        System.out.println("===============================");
    }

    private static boolean addCityInOrder(LinkedList<String> linkedList, String cityName) {
        // a ListIterator CAN move forward AND backward through the list
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()) {
            // this line is important because a ListIterator is NOT automatically pointing at the first entry in a list
            // the .next() is required to start at the first entry of the list
            int comparison = stringListIterator.next().compareTo(cityName);
            if(comparison == 0) {
                // 0 means the cityName is the same as the cityName at this index
                System.out.println("Destination city already added to list");
                return false;
            } else if (comparison > 0 ) {
                // means the current cityName is alphabetically before the current city name
                // Denver --> Atlanta (Atlanta compareTo(Denver) is greater than 0
                stringListIterator.previous();
                stringListIterator.add(cityName);
                return true;
            } else if (comparison < 0){
                // mean comparison is less than 0
                // Denver <-- Toronto (Denver compareTo(Toronto) is less than 0
                // the .next() in the int variable is already moving on to the next indexed value
            }
        }
        stringListIterator.add(cityName);
        return true;
    }

    private static void visit(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        ListIterator<String> listIterator = cities.listIterator();
        boolean quit = false;
        boolean goingForward = true;

        if(cities.isEmpty()) {
            System.out.println("No cities exist on the itinerary");
        } else {
            System.out.println("Now visiting: " + listIterator.next());
            printMenu();
        }

        while(!quit) {
            int selection = scanner.nextInt();
            scanner.nextLine();
            switch(selection) {
                case 0:
                    System.out.println("Vacation time over!");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now visiting: " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list!");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting: " + listIterator.previous());
                    } else {
                        System.out.println("This is the beginning of the travel itinerary");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n Press one option to continue ");
        System.out.println("\t Press 0 - To quit the application");
        System.out.println("\t Press 1 - To visit the next vacation spot");
        System.out.println("\t Press 2 - To visit the previous vacation spot");
        System.out.println("\t Press 3 - To print the vacation options");
    }

    private static void playSongs(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> listIterator = playList.listIterator();
        boolean quit = false;
        boolean goingForward = true;

        if(playList.isEmpty()) {
            System.out.println("There are no songs currently on the play list");
        } else {
            System.out.println("Now playing: " + listIterator.next().toString());
            printPlaylistMenu();
        }

        while(!quit) {
            int selection = scanner.nextInt();
            scanner.nextLine();
            switch(selection) {
                case 0:
                    System.out.println("Music time is over!");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing: " + listIterator.next().toString());
                    } else {
                        System.out.println("Reached the end of the list!");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now playing: " + listIterator.previous().toString());
                    } else {
                        System.out.println("This is the beginning of the play list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if(goingForward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing: " + listIterator.previous().toString());
                            goingForward = false;
                        } else {
                            System.out.println("This is the beginning of the play list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying: " + listIterator.next().toString());
                            goingForward = true;
                        } else {
                            System.out.println("Reached the end of the list!");
                        }
                    }
                    break;
                case 4:
                    if(playList.size() > 0) {
                        playList.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing: " + listIterator.next().toString());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing: " + listIterator.previous().toString());
                        }
                    }
                    break;
                case 5:
                    printPlayList(playList);
                    break;
                case 6:
                    printPlaylistMenu();
                    break;
            }
        }
    }

    private static void printPlaylistMenu() {
        System.out.println("\n Press one option to continue ");
        System.out.println("\t Press 0 - To quit the application");
        System.out.println("\t Press 1 - To play the next song on the play list");
        System.out.println("\t Press 2 - To play the previous song on the play list");
        System.out.println("\t Press 3 - To replay the current song on the play list");
        System.out.println("\t Press 4 - To remove the current song from the play list");
        System.out.println("\t Press 5 - To print the list of songs on the play list");
        System.out.println("\t Press 6 - To print the list of options for the play list");
    }

    private static void printPlayList(LinkedList<Song> linkedList) {
        // is acting like a manually written for loop
        // an Iterator can not move forward and backward it only moves one direction through the list
        Iterator<Song> i = linkedList.iterator();

        System.out.println("=======================================");
        while(i.hasNext()) { // the check for while for a hasNext() value
            System.out.println("Song: " + i.next().toString()); // i.next() returns i AND performs i++
        }
        System.out.println("=======================================");
    }
}
