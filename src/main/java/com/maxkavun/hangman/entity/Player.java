package main.java.com.maxkavun.hangman.entity;
/*
    The Player class represents the player in the game.
    It is responsible for storing the player's information and handling any player-specific actions or data.
 */

public class Player {

    private String playerName;
    private int scoreOfLose;
    private int scoreOfWin ;

    public Player() {}


    public void incrementScoreOfWin() {
        scoreOfWin++;
    }

    public void incrementScoreOfLose() {
        scoreOfLose++;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScoreOfLose() {
        return scoreOfLose;
    }

    public void setScoreOfLose(int scoreOfLose) {
        this.scoreOfLose = scoreOfLose;
    }

    public int getScoreOfWin() {
        return scoreOfWin;
    }

    public void setScoreOfWin(int scoreOfWin) {
        this.scoreOfWin = scoreOfWin;
    }
}
