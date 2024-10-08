package main.java.com.maxkavun.hangman.service;


import main.java.com.maxkavun.hangman.entity.Player;
import main.java.com.maxkavun.hangman.utils.StringUtils;
import main.java.com.maxkavun.hangman.utils.HangmanDisplay;

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
            System.out.println(StringUtils.getStrings("enter_letter"));

            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1) {
                System.out.println(StringUtils.getStrings("one_letter"));
                continue;
            }

            if (characterSet.contains(input.charAt(0))) {
                System.out.println(StringUtils.getStrings("already_entered"));
                continue;
            }

            char letter = input.charAt(0);

            characterSet.add(letter);

            gameState.updateCurrentState(letter);
            hangmanDisplay.drawHangman();
            System.out.println(gameState.getCurrentStateOfTheWord());
            System.out.println(StringUtils.getStrings("mistakes") + gameState.getErrors()+"/6");

            if (gameState.isLose()) {
                player.incrementScoreOfLose();
                characterSet.clear();
                System.out.println(StringUtils.getStrings("lose") + wordGenerator.getRandomWord() + "\n");
            }

            if (gameState.isVictory()){
                player.incrementScoreOfWin();
                characterSet.clear();
                System.out.println(StringUtils.getStrings("win") + "\n");
            }
        }
    }

    public void endGame(){
        System.out.println("\n"+ StringUtils.getStrings("thank_you")+ player.getPlayerName() + StringUtils.getStrings("see_you"));
        System.out.println(StringUtils.getStrings("final_score"));
        System.out.println(StringUtils.getStrings("win_count") + player.getScoreOfWin());
        System.out.println(StringUtils.getStrings("lose_count") + player.getScoreOfLose());
        System.exit(0);
    }



}
