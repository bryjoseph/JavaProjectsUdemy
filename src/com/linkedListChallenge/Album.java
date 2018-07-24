package com.linkedListChallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> trackList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.trackList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Song> getTrackList() {
        return trackList;
    }

    public void setTrackList(ArrayList<Song> trackList) {
        this.trackList = trackList;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Adding to the ArrayList
    public boolean addNewSongToAlbum(String songName, double songDuration) {

        if(queryTrackList(songName) != null ) {
            System.out.println("Song title: " + songName + " already exists on this album");
            return false;
        } else {
            System.out.println("Song " + songName + " successfully added to the album");
            this.trackList.add(Song.createSong(songName, songDuration));
            return true;
        }
    }

    // Searching the ArrayList to return customerName
    // return the Customer instance the user might search for
    private Song queryTrackList(String songName) {

        // could forEach here and save a little bit of time processing the command
        for(int i = 0; i < this.trackList.size(); i++) {
            Song matchingSong = this.trackList.get(i);
            if(matchingSong.getTitle().equals(songName)) {
                return matchingSong;
            }
        }
        return null;
    }
    // if the user decides to enter the track number to add a song
    public boolean addSongToPlaylist(LinkedList<Song> playList, int trackNumber) {
        // counting the values like an index (minus 1)
        int songIndex = trackNumber - 1;
        // filter out a 0 or negative trackNumber, and the max is less than the end of the trackList
        if((songIndex >= 0) && (songIndex <= this.trackList.size())) {
            // add the song from the trackList at that index value TO the new playList LinkedList
            System.out.println("Song " + this.trackList.get(songIndex) + " added as number: " + trackNumber);
            playList.add(this.trackList.get(songIndex));
            return true;
        } else {
            System.out.println("Track number " + trackNumber + " not valid");
            return false;
        }
    }

    // if the user decides to enter the song title to add a song
    public boolean addSongToPlaylist(LinkedList<Song> playList, String songTitle) {
        Song matchingSongTitle = queryTrackList(songTitle);
        if(matchingSongTitle != null) {
            System.out.println("Song " + matchingSongTitle.getTitle() + " added to play list");
            playList.add(matchingSongTitle);
            return true;
        } else {
            System.out.println("The song titled " + songTitle + " was not found");
            return false;
        }
    }

    public static Album createAlbum(String name, String artist) { return new Album(name, artist); }
}
