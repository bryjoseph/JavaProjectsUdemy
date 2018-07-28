package com.interfacesAndAbstractClasses.copyOfLinkedListCode;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlayList {

    private String listName;
    private LinkedList<String> playList;


    public PlayList(String listName) {
        this.listName = listName;
        this.playList = new LinkedList<>();
    }

    public String getListName() {
        return listName;
    }

    public LinkedList<String> getPlayList() {
        return playList;
    }

    private boolean addSongInOrder(LinkedList<String> playList, Song song) {

        ListIterator<String> songListIterator = this.playList.listIterator();

        boolean comparison = songListIterator.next().equals(song.getTitle());

        if(comparison) {
            System.out.println("Song " + song.getTitle() + " already added to list");
            return false;
        } else {
            this.playList.add(song.getTitle());
            return true;
        }
    }

    public void playSongs(LinkedList<String> playList) {
        Scanner scanner = new Scanner(System.in);
        ListIterator<String> listIterator = this.playList.listIterator();
        boolean quit = false;
        boolean goingForward = true;

        if(playList.isEmpty()) {
            System.out.println("There are no songs currently on the play list");
        } else {
            System.out.println("Now playing: " + listIterator.next());
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
}
