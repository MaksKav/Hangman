package com.maxkavun.hangman;

import java.util.Scanner;

import static com.maxkavun.hangman.Strings.getStrings;
import static com.maxkavun.hangman.Strings.loadLocalization;

public class Main {

    public static String language = "notNULL";

    public static void startingDisplayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean bool = true;
        System.out.println("Choose your language  |  Виберіть мову");
        System.out.println("Please write ENG | Будь ласка напишіть УКР");
        while (bool) {
            language = scanner.nextLine();
            language = language.toLowerCase();
            if (language.equals("eng") || language.equals("укр")) {
                bool = false;
                loadLocalization(language);
            } else {
                System.out.println("You entered an incorrect command , try again. | Введена неправильна команда , спробуйте ще раз");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        WordGenerator wordGenerator = new WordGenerator();
        GameState gameState = new GameState();
        Menu menu = new Menu(scanner, player);
        HangmanDisplay hangmanDisplay = new HangmanDisplay(gameState);

        HangmanGame hangmanGame = new HangmanGame(scanner, wordGenerator, gameState, hangmanDisplay, player, menu);

        startingDisplayMenu();

        hangmanGame.startGame();
    }
}
