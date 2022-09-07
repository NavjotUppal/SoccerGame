package soccergame;

public class SoccerGame {

    public static void main(String[] args) {
        Scheduler schedule = new Scheduler();
        Team t = new Team();
        Team[] teams = new Team[4];
        for (int i = 0; i < 4; i++) {
            teams[i] = new Team();
        }
        t.setTeams(teams);
        schedule.scheduleGame(teams);
    }

}
