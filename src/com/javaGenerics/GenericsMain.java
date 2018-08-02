package com.javaGenerics;

import java.util.ArrayList;

public class GenericsMain {

    public static void main(String[] args) {

        // this ArrayList is known as a RAW list
        // ArrayList list = new ArrayList();

        ArrayList<Integer> list2 = new ArrayList<>();

        list2.add(1);
        list2.add(2);
        list2.add(3);
        // notice no compile-time error here...yet
       //  list2.add("Broj");
        list2.add(4);
        list2.add(5);

        // at run-time, the ClassCastException error occurs because in the for loop
        // the o is being cast to Integer
        printDoubledValues(list2);


        // creating a new team
        FootballPlayer fridge = new FootballPlayer("Fridge");
        BaseballPlayer babe = new BaseballPlayer("Babe");
        SoccerPlayer pele = new SoccerPlayer("Pele");
        SoccerPlayer neymar =  new SoccerPlayer("Neymar");

        Team<FootballPlayer> denverAC = new Team<>("Denver AC");
        denverAC.addPlayer(fridge);
//        denverAC.addPlayer(babe);
//        denverAC.addPlayer(pele);

        Team<BaseballPlayer> coloradoRockies = new Team<>("Colorado Rockies");
        Team<BaseballPlayer> cincinnatiReds = new Team<>("Cincinnati Reds");
        coloradoRockies.addPlayer(babe);

        Team<SoccerPlayer> coloradoRapids = new Team<>("Colorado Rapids");
        coloradoRapids.addPlayer(pele);
        Team<SoccerPlayer> dallasFire = new Team<>("Dallas Fire");
        dallasFire.addPlayer(neymar);
        Team<SoccerPlayer> tottenhamHotspur = new Team<>("Tottenham Hotspur");

        System.out.println(denverAC.getNumberOfPlayers());

        // premier teams results
        coloradoRapids.matchResult(dallasFire, 2, 1);
        dallasFire.matchResult(tottenhamHotspur, 1, 5);
        tottenhamHotspur.matchResult(coloradoRapids, 3,1);


        cincinnatiReds.matchResult(coloradoRockies, 5, 3);

        System.out.println(coloradoRapids.getTeamName() + " ranked: " + coloradoRapids.teamRanking());
        System.out.println(cincinnatiReds.getTeamName() + " ranked: " + cincinnatiReds.teamRanking());
        System.out.println(coloradoRockies.getTeamName() + " ranked: " + coloradoRockies.teamRanking());

        System.out.println(cincinnatiReds.compareTo(coloradoRockies));

        LeagueTable<Team<SoccerPlayer>> premierLeague = new LeagueTable<>("Premier League");
        premierLeague.addTeamToLeague(coloradoRapids);
        premierLeague.addTeamToLeague(dallasFire);
        premierLeague.addTeamToLeague(tottenhamHotspur);
        // test to block wrong Team type
        // premierLeague.addTeamToLeague(cincinnatiReds);
        premierLeague.printLeagueTable();





    }


    // added the type parameter to the method call and for loop
    // instead of having Object o and casting, Integer is the proper type parameter
    private static void printDoubledValues(ArrayList<Integer> list) {
        for(Integer o : list) {
            System.out.println( o * 2 );
        }
    }







}
