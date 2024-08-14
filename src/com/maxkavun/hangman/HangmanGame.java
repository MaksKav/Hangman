package com.maxkavun.hangman;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HangmanGame {
    public static Set <Character> characterSet = new HashSet<Character>(); ;

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

    public void startGame_Eng() {

        menu.firstDisplayMenu_Eng();
        while (true){
            menu.secondDisplayMenu_Eng();
            int choice = menu.secondDisplayMenuChoice_Eng();
            if (choice == 2) {
                endGame_Eng();
            }else {
                if (gameState.getErrors()>0){
                    gameState.setErrors(0);
                }
                continueGame_Eng();
            }
        }
    }

    public void continueGame_Eng() {
        wordGenerator.loadWord_Eng();
        gameState.initGameState(wordGenerator.getRandomWord());

        while(!gameState.isGameOver()){
            System.out.println("Enter a letter");

            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("Please enter only one letter.");
                continue;
            }

            if (characterSet.contains(input.charAt(0))) {
                System.out.println("You've already entered this letter, please try again");
                continue;
            }

            char letter = input.charAt(0);
            characterSet.add(letter);

            gameState.updateCurrentState(letter);
            hangmanDisplay.drawHangman();
            System.out.println(gameState.getCurrentStateOfTheWord());
            System.out.println("Mistakes: " + gameState.getErrors()+"/6");

            if (gameState.isLose()) {
                player.incrementScoreOfLose();
                characterSet.clear();
                System.out.println("Oh, you lost. The correct word was --> " + wordGenerator.getRandomWord() + "\n");
            }

            if (gameState.isVictory()){
                player.incrementScoreOfWin();
                characterSet.clear();
                System.out.println("Congratulation ! You won!" + "\n");
            }

        }

    }

    public void endGame_Eng(){
        System.out.println("\nThank you for playing '"+ player.getPlayerName() +"' see you next time!");
        System.out.println("Your final score is:");
        System.out.println("Win :" + player.getScoreOfWin());
        System.out.println("Lose :" + player.getScoreOfLose());
        System.exit(0);
    }


    // Methods for ukrainian languages

    public void startGame_Ukr() {

        menu.firstDisplayMenu_Ukr();
        while (true) {
            menu.secondDisplayMenu_Ukr();
            int choice = menu.secondDisplayMenuChoice_Ukr();
            if (choice == 2) {
                endGame_Ukr();
            } else {
                if (gameState.getErrors() > 0) {
                    gameState.setErrors(0);
                }
                continueGame_Ukr();
            }
        }
    }

    public void continueGame_Ukr() {
        wordGenerator.loadWord_Ukr();
        gameState.initGameState(wordGenerator.getRandomWord());

        while (!gameState.isGameOver()) {
            System.out.println("Введіть літеру");

            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("Будь ласка, введіть лише одну літеру.");
                continue;
            }

            if (characterSet.contains(input.charAt(0))) {
                System.out.println("Ви вже вводили цю літеру , спробуйте знову ");
                continue;
            }

            char letter = input.charAt(0);
            characterSet.add(letter);

            gameState.updateCurrentState(letter);
            hangmanDisplay.drawHangman();
            System.out.println(gameState.getCurrentStateOfTheWord());
            System.out.println("Помилки: " + gameState.getErrors() + "/6");

            if (gameState.isLose()) {
                player.incrementScoreOfLose();
                characterSet.clear();
                System.out.println("На жаль, ви програли. Правильне слово було --> " + wordGenerator.getRandomWord() + "\n");
            }

            if (gameState.isVictory()) {
                player.incrementScoreOfWin();
                characterSet.clear();
                System.out.println("Вітаємо! Ви виграли!" + "\n");
            }
        }
    }

    public void endGame_Ukr() {
        System.out.println("\nДякуємо за гру '" + player.getPlayerName() + "' до наступного разу!");
        System.out.println("Ваш остаточний рахунок:");
        System.out.println("Перемог: " + player.getScoreOfWin());
        System.out.println("Поразок: " + player.getScoreOfLose());
        System.exit(0);
    }
}
