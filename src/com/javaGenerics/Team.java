package com.javaGenerics;

import java.util.ArrayList;

// telling Java T can accept any type of Player or Subclass of player
// Player is the upper bound of T
// T is a bounded type parameter
public class Team<T extends Player> implements Comparable<Team<T>> {

    private String teamName;
    private int gamesPlayed = 0;
    private int gamesWon = 0;
    private int gamesLost = 0;
    private int gamesTied = 0;

    private ArrayList<T> teamMembers = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public boolean addPlayer(T player) {
        if(teamMembers.contains(player)) {
            System.out.println("Player: " + player.getName() + " is already on the team");
            return false;
        } else {
            teamMembers.add(player);
            System.out.println("Player: " + player.getName() + " added to " + this.teamName);
            return true;
        }
    }

    public int getNumberOfPlayers() {
        return this.teamMembers.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;

        if(ourScore > theirScore) {
            gamesWon++;
            message = " beat ";
        } else if (theirScore > ourScore) {
            gamesLost++;
            message = " lost to ";
        } else {
            gamesTied++;
            message = " drew with ";
        }
        gamesPlayed++;
        if(opponent != null) {
            System.out.println(this.teamName + message + opponent.getTeamName());
            // reverse the results for the opponents score keeping
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int teamRanking() {
        return (gamesWon * 2) + gamesTied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.teamRanking() > team.teamRanking()) {
            return -1;
        } else if(this.teamRanking() < team.teamRanking()) {
            return 1;
        } else {
            return 0;
        }
    }
}
