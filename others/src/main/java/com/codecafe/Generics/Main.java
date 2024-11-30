package com.codecafe.Generics;

interface Player{

}

record BaseballPlayer(String name, String position) implements Player{
}
record FootballPlayer(String name, String position) implements Player{

}

public class Main {

    public static void main(String[] args) {
        BaseballTeam phillis = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros = new BaseballTeam("Houston Astros");
        scoreResult(phillis, 3, astros, 5);

        SportsTeam phillis1 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros1 = new SportsTeam("Houston Astros");
        scoreResult(phillis, 3, astros, 5);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillis.addTeamMember(harper);
        phillis.addTeamMember(marsh);
        phillis.listTeamMembers();

        SportsTeam afc = new SportsTeam("Adelaide Crows");
        var tex = new FootballPlayer("Tex Walker", "Centre half forward");
        afc.addTeamMember(tex);
        // Here there is an issue with this approach. What is that?
        // I can able to add any member without type checking. Here I added baseball player
        // into foot ball player. This is wrong right? Here, Generics comes into the picture
        afc.addTeamMember(marsh);
        afc.addTeamMember(harper);
        afc.listTeamMembers();

    }
    public static void scoreResult(BaseballTeam team1, int t1_score,
                                   BaseballTeam team2, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    public static void scoreResult(SportsTeam team1, int t1_score,
                                   SportsTeam team2, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

}