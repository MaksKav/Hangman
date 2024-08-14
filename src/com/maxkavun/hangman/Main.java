package com.maxkavun.hangman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        WordGenerator wordGenerator = new WordGenerator();
        GameState gameState = new GameState();
        Menu menu = new Menu(scanner , player);
        HangmanDisplay hangmanDisplay = new HangmanDisplay(gameState);

        HangmanGame hangmanGame = new HangmanGame(scanner , wordGenerator , gameState , hangmanDisplay , player , menu);

        hangmanGame.startGame();
    }
}
