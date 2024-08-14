package com.maxkavun.hangman;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class HangmanGame {
    private Scanner scanner ;
    private final WordGenerator wordGenerator;
    private final GameState gameState;
    private final HangmanDisplay hangmanDisplay;
    private final Player player;
    private final Menu menu ;



    public HangmanGame(Scanner scanner, WordGenerator wordGenerator, GameState gameState, HangmanDisplay hangmanDisplay, Player player, Menu menu) {
        this.wordGenerator = wordGenerator;
        this.gameState = gameState;
        this.hangmanDisplay = hangmanDisplay;
        this.player = player;
        this.menu = menu;
        this.scanner = scanner;
    }

    public void startGame() {
        menu.firstDisplayMenu();
        while (true){
            menu.secondDisplayMenu();
            int choice = menu.secondDisplayMenuChoice();
            if (choice == 2) {
                endGame();
            }else {
                if (gameState.getErrors()>0){
                    gameState.setErrors(0);
                }
                continueGame();
            }
        }
    }

    public void continueGame() {
        wordGenerator.loadWord();
        gameState.initGameState(wordGenerator.getRandomWord());

        while(!gameState.isGameOver()){
            System.out.println("Enter a letter");

            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("Please enter only one letter.");
                continue;
            }
            char letter = input.charAt(0);

            gameState.updateCurrentState(letter);
            hangmanDisplay.drawHangman();
            System.out.println(gameState.getCurrentStateOfTheWord());
            System.out.println("Mistakes: " + gameState.getErrors()+"/6");

            if (gameState.isLose()) {
                player.incrementScoreOfLose();
                System.out.println("Oh, you lost. The correct word was --> " + wordGenerator.getRandomWord() + "\n");
            }

            if (gameState.isVictory()){
                player.incrementScoreOfWin();
                System.out.println("Congratulation ! You won!" + "\n");
            }

        }

    }

    public void endGame (){
        System.out.println("\nThank you for playing "+ player.getPlayerName() +", see you next time!");
        System.out.println("Your final score is:");
        System.out.println("Win :" + player.getScoreOfWin());
        System.out.println("Lose :" + player.getScoreOfLose());
        System.exit(0);
    }




}
