package soccergame;

import java.util.Random;
import java.util.ArrayList;

public class Game {

    int gameCounter = 0;
    private float hotTemp = 0.0f;
    private float sumTemp = 0.0f;
    private float temperature = 0.0f;
    int homeTeamScore, awayTeamScore;
    Random random = new Random();
    private final ArrayList<Game> games = new ArrayList<Game>();

    public void gameScore(float temperature, Team homeTeam, Team awayTeam) {
        this.temperature = temperature;
        homeTeamScore = (int) (temperature / 10) + random.nextInt(10);
        awayTeamScore = (int) (temperature / 10) + random.nextInt(10);
        homeTeam.setTotalGoalScored(homeTeamScore);
        awayTeam.setTotalGoalScored(awayTeamScore);
    }

    public void findTemperature(float temperature) {
        try {
            this.temperature = temperature;
            sumTemp = sumTemp + temperature;
            if (hotTemp < temperature) {
                hotTemp = temperature;
            }
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occured. Please Check the logic.");
        }
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    @Override
    public String toString() {
        if (gameCounter == 0) {
            return " ";
        } else {
            return "Number of games played in the season: " + gameCounter
                    + "\nHottest Temperature of the season: " + hotTemp
                    + "\nAverage Temperature of the season: " + (float) (sumTemp / gameCounter);

        }

    }
}
