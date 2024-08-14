package com.maxkavun.hangman;

import java.util.Scanner;

public class Main {

    public static String language = "notNULL";

    public static void startingDisplayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean bool = true;
        System.out.println("Choose your language  |  Виберіть мову");
        System.out.println("Please write ENG | Будь ласка напишіть УКР");
        while (bool) {
            language = scanner.nextLine();
            if (language.equals("eng") || language.equals("ENG") || language.equals("укр") || language.equals("УКР")) {
                bool = false;
                language = language.toLowerCase();
            } else {
                System.out.println("You entered an incorrect command , try again. | Введена неправильна команда , спробуйте ще раз");
                scanner.nextLine();
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

        if (language.equals("eng")) {
            hangmanGame.startGame_Eng();
        } else if (language.equals("укр")) {
            hangmanGame.startGame_Ukr();
        }
    }
}
