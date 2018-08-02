package com.javaGenerics;

import java.util.ArrayList;
import java.util.Collections;

public class LeagueTable<T extends Team> {

    private String leagueName;
    private ArrayList<T> leagueTeams = new ArrayList<>();

    public LeagueTable(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public ArrayList<T> getLeagueTeams() {
        return leagueTeams;
    }

    public void addTeamToLeague(T team) {
        if(leagueTeams.contains(team)) {
            System.out.println("Team: " + team.getTeamName() + " is already in the league");
        } else {
            leagueTeams.add(team);
            System.out.println("Team: " + team.getTeamName() + " successfully added to " + this.leagueTeams);
        }
    }

    public void printLeagueTable() {
        Collections.sort(leagueTeams);

        for(T t: leagueTeams) {
            System.out.println("Team: " + t.getTeamName() + " is ranked: " + t.teamRanking());
        }
    }
}
