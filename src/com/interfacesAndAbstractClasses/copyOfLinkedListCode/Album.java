package com.interfacesAndAbstractClasses.copyOfLinkedListCode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new SongList();
    }

    // getters / setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SongList getSongList() { return songList; }

    public void setSongList(SongList songList) { this.songList = songList; }

    public String getArtist() { return artist; }

    public void setArtist(String artist) { this.artist = artist; }

    // example of Inner Class
    public class SongList {

        private ArrayList<Song> trackList;

        public SongList() {
            this.trackList = new ArrayList<>();
        }

        public ArrayList<Song> getTrackList() { return trackList; }

        private boolean addSongToList(Song newSong) {
            if(queryTrackList(newSong.getTitle()) != null) {
                System.out.println("Song: " + newSong.getTitle() + " already exists on the album");
                return false;
            } else {
                System.out.println("Song " + newSong.getTitle() + " successfully added to the album");
                this.trackList.add(newSong);
                return true;
            }
        }

        private Song queryTrackList(String songName) {

            // Java 10 version of this forLoop
            // return this.trackList.stream().filter(matchingSong -> matchingSong.getTitle().equals(songName)).findFirst().orElse(null);

            // could forEach here and save a little bit of time processing the command
            for (Song matchingSong : this.trackList) {
                if (matchingSong.getTitle().equals(songName)) {
                    return matchingSong;
                }
            }
            return null;
        }

        private Song queryTrackList(int songIndex) {

            int index = songIndex - 1;
            if ((index >= 0) && (index < this.trackList.size())) {
                return this.trackList.get(index);
            } else {
                System.out.println("The track number does not exist on this album");
                return null;
            }
        }
    }

    // Adding to the new INNER CLASS SongList
    public void addSong(String newSongName, double newSongDuration) {
        Song newSong = new Song(newSongName, newSongDuration);

        if(songList.addSongToList(newSong)) {
            System.out.println("Song " + newSongName + " added successfully");
        } else {
            System.out.println("Song " + newSongName + " not added successfully");
        }
    }

    // Searching the ArrayList to return customerName
    public void querySongList(String searchedSongName) {
        if(songList.queryTrackList(searchedSongName) != null) {
            System.out.println("Song " + searchedSongName + " found on song list");
        } else {
            System.out.println("Song " + searchedSongName + " not found on album");
        }
    }

    // if the user decides to enter the track number to add a song
    public boolean addSongToPlaylist(LinkedList<Song> playList, int trackNumber) {
        Song matchingSong = this.songList.queryTrackList(trackNumber);

        if(matchingSong != null) {
            System.out.println("Song " + matchingSong.getTitle() + " added as number: " + trackNumber);
            playList.add(matchingSong);
            return true;
        } else {
            System.out.println("Track number " + trackNumber + " not valid");
            return false;
        }
    }

    // if the user decides to enter the song title to add a song
    public boolean addSongToPlaylist(LinkedList<Song> playList, String songTitle) {
        Song matchingSongTitle = this.songList.queryTrackList(songTitle);

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
