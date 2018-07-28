package com.interfacesAndAbstractClasses.copyOfLinkedListCode;

public class Song {

    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    // this is going to be related to the way an iterator works with strings instead of objects
    @Override
    public String toString() {
        return this.title + " : " + this.duration;
    }

    public static Song createSong(String title, double duration) { return new Song(title, duration); }
}
