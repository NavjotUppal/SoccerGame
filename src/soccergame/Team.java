package soccergame;

public class Team {

    private String teamName = "";
    private int winTotal;
    private int lossTotal;
    private int tieTotal;
    private int totalGoalScored = 0;
    private int totalGoalAllowed;
    private Team[] teams = new Team[4];
    private char ch = 'A';

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getWinTotal() {
        return winTotal;
    }

    public void setWinTotal(int winTotal) {
        this.winTotal = winTotal;
    }

    public int getLossTotal() {
        return lossTotal;
    }

    public void setLossTotal(int lossTotal) {
        this.lossTotal = lossTotal;
    }

    public int getTieTotal() {
        return tieTotal;
    }

    public void setTieTotal(int tieTotal) {
        this.tieTotal = tieTotal;
    }

    public int getTotalGoalScored() {
        return totalGoalScored;
    }

    public void setTotalGoalScored(int totalGoalScored) {
        this.totalGoalScored = totalGoalScored;
    }

    public int getTotalGoalAllowed() {
        return totalGoalAllowed;
    }

    public void setTotalGoalAllowed(int winTotal, int lossTotal, int tieTotal) {
        totalGoalAllowed =  winTotal + lossTotal + tieTotal;
    }

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] ts) {
        this.teams = ts;
        for (int i = 0; i < 4; i++) {
            teams[i].teamName = ("Team " + ch);
            System.out.println(teams[i].teamName);
            ch++;
        }
    }
}
