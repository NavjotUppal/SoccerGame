package soccergame;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Scheduler {

    float temperature;
    private int freezeDay = 0;
    boolean seasonOver = false;
    Team[] homeTeam = new Team[2];
    Team[] awayTeam = new Team[2];
    Game game = new Game();
    private Team[] teams;
    Scanner input = new Scanner(System.in);
    Random random = new Random();
    private final ArrayList<Game> games;

    public Scheduler() {
        this.games = new ArrayList<Game>();
    }

    public void scheduleGame(Team[] teams) {
        this.teams = teams;
        while (!seasonOver) {
            if (freezeDay < 3) {
                System.out.println("What is today's temperature(in Fahrenheit)?");
                if (input.hasNextFloat()) {
                    temperature = input.nextFloat();
                    if (temperature < 30) {
                        System.out.println("Too Cold to Play");
                        freezeDay++;
                        continue;
                    } else {
                        freezeDay = 0;
                    }
                    chooseTeams();
                    game.gameCounter++;
                } else {
                    if (!input.hasNextFloat()) {
                        System.out.println("Please Enter the Valid Temperature: ");
                        input.next();
                    }
                }
            } else if (freezeDay == 3) {
                System.out.println("Season is Over.");
                System.out.println(game.toString());
                seasonOver = true;
            }
        }
    }

    public void chooseTeams() {
        try {
            game.findTemperature(temperature);
            for (int i = 0; i < 2; i++) {
                homeTeam[i] = teams[random.nextInt(teams.length)];
                awayTeam[i] = teams[random.nextInt(teams.length - 1)];
                while (homeTeam[i] == awayTeam[i]) {
                    awayTeam[i] = teams[random.nextInt(teams.length)];
                }
                if (i == 1) {
                    while (homeTeam[i] == homeTeam[i - 1] || homeTeam[i] == awayTeam[i - 1] || homeTeam[i] == awayTeam[i]) {
                        homeTeam[i] = teams[random.nextInt(teams.length)];
                    }
                    while (awayTeam[i] == homeTeam[i - 1] || awayTeam[i] == awayTeam[i - 1] || homeTeam[i] == awayTeam[i]) {
                        awayTeam[i] = teams[random.nextInt(teams.length)];
                    }
                }
                System.out.println("Game" + (i + 1));
                System.out.println("Team " + homeTeam[i].getTeamName() + " V/s Team " + awayTeam[i].getTeamName() + " is scheduled");
            }
            for (int i = 0; i < 2; i++) {
                game.gameScore(temperature, homeTeam[i], awayTeam[i]);
                if (homeTeam[i].getTotalGoalScored() > awayTeam[i].getTotalGoalScored()) {
                    homeTeam[i].setWinTotal(homeTeam[i].getTotalGoalScored());
                    awayTeam[i].setLossTotal(awayTeam[i].getTotalGoalScored());
                } else if (homeTeam[i].getTotalGoalScored() < awayTeam[i].getTotalGoalScored()) {
                    homeTeam[i].setLossTotal(homeTeam[i].getTotalGoalScored());
                    awayTeam[i].setWinTotal(awayTeam[i].getTotalGoalScored());
                } else {
                    homeTeam[i].setTieTotal(homeTeam[i].getTotalGoalScored());
                    awayTeam[i].setTieTotal(awayTeam[i].getTotalGoalScored());
                }
                for(Game game:games){
                games.add(game);
                }
                homeTeam[i].setTotalGoalAllowed(homeTeam[i].getWinTotal(), homeTeam[i].getLossTotal(), homeTeam[i].getTieTotal());
                awayTeam[i].setTotalGoalAllowed(awayTeam[i].getWinTotal(), awayTeam[i].getLossTotal(), awayTeam[i].getTieTotal());
                System.out.println("Round " + (i + 1) + " summary:");
                System.out.println("Home Team: " + homeTeam[i].getTeamName()
                        + "\n Win: " + homeTeam[i].getWinTotal()
                        + "\n Lost: " + homeTeam[i].getLossTotal()
                        + "\n Tie: " + homeTeam[i].getTieTotal()
                        + "\nAway Team: " + awayTeam[i].getTeamName()
                        + "\n Win: " + awayTeam[i].getWinTotal()
                        + "\n Lost: " + awayTeam[i].getLossTotal()
                        + "\n Tie: " + awayTeam[i].getTieTotal()
                        + "\n Points allowed: " + (awayTeam[i].getTotalGoalAllowed() + homeTeam[i].getTotalGoalAllowed())
                );             
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Out of Bound Exception occured");
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception Occured");
        }
    }
}
