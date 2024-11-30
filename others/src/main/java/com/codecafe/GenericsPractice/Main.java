package com.codecafe.GenericsPractice;


interface Player{
    String name();
    // Any method defined on an interface without a method body, is implicitly public and
    // static on an interface
}

record BaseballPlayer(String name, String position) implements Player {
}
record FootballPlayer(String name, String position) implements Player {

}
record VolleyballPlayer(String name, String position) implements Player{}

public class Main {

    public static void main(String[] args) {

        var philly = new Affiliation("city", "Philadelphia, PA", "US");
        BaseballTeam phillis = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros = new BaseballTeam("Houston Astros");

        scoreResult(phillis, 3, astros, 5);

        SportsTeam phillis2 = new SportsTeam("Philadelphia Phillies");
        SportsTeam astros2 = new SportsTeam("Houston Astros");
        phillis2.listTeamMembers();
        scoreResult(phillis2, 3, astros2, 5);

        Team<BaseballPlayer, Affiliation> phillis1 = new Team<>("Philadelphia Phillies", philly);
        Team<BaseballPlayer, Affiliation> astros1 = new Team<>("Houston Astros", philly);
        phillis1.listTeamMembers();
        scoreResult(phillis1, 0, astros1, 1);

        var harper = new BaseballPlayer("B Harper", "Right Fielder");
        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
        phillis.addTeamMember(harper);
        phillis.listTeamMembers();

        SportsTeam afc1 = new SportsTeam("Adelaide Crows");
        Team<FootballPlayer, Affiliation> afc = new Team<>("Adelainde Crows");
        var tex = new FootballPlayer("Tex Walker", "Centre half forward");
        afc.addTeamMember(tex);
        // Now, after applying generics, It's showing error while adding wrong type.
        //--afc.addTeamMember(marsh);--// Important
        afc.listTeamMembers();

        // Here, we are using String type, so we can add different players to the team. Again there
        // is a problem right. For that we need to changes one thing in Team class
        // public class Team<T extends Player>{}
        // Now it's showing error
       // Team<String> adelaide = new Team<>("Adelaide Storm"); // showing error
       // adelaide.addTeamMember("N Roberts");
       // adelaide.listTeamMembers();

        var adelaide = new Team<VolleyballPlayer, Affiliation>("Adelaide Storm"); // showing error
        // adelaide.addTeamMember("N Roberts");
        // adelaide.listTeamMembers();

        var canberra = new Team<VolleyballPlayer, Affiliation>("Canberra Heat", philly); // showing error
        canberra.addTeamMember(new VolleyballPlayer("B Black", "Opposite"));
        canberra.listTeamMembers();
        scoreResult(canberra, 0, adelaide, 1);
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

    public static void scoreResult(Team team1, int t1_score,
                                   Team team2, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}