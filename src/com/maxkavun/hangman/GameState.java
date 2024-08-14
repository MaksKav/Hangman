package com.maxkavun.hangman;

import java.util.HashSet;
import java.util.Set;

/*
    The GameState class is responsible for storing and managing the current state of the game.
    This includes tracking the word to guess, the current progress of the player's guesses,
    the number of incorrect guesses, and any letters that have been guessed so far.
 */

public class GameState {

    private String wordToGuess;
    private StringBuilder currentStateOfTheWord;
    private int errors;
    private Set<Character> charsOfWord;


    public GameState() {

    }

    /*
       This method will update the current state of the word that the user is trying to guess or the error counter.
    */
    public void updateCurrentState(char character) {
        if (charsOfWord.contains(character)) {
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == character) {
                    currentStateOfTheWord.setCharAt(i, character);
                }
            }
        } else {
            incrementErrors();
        }
    }

    public void initGameState(String wordToGuess){
        this.wordToGuess = wordToGuess;
        this.currentStateOfTheWord = new StringBuilder("_".repeat(wordToGuess.length()));
        this.charsOfWord = new HashSet<>();
        for (char c : wordToGuess.toCharArray()) {
            charsOfWord.add(c);
        }
    }

    public boolean isGameOver() {
        return errors >= 6 || currentStateOfTheWord.indexOf("_") == -1;
    }

    public boolean isVictory(){
        return currentStateOfTheWord.indexOf("_") == -1;
    }

    public boolean isLose (){
        return errors >= 6;
    }

    public void incrementErrors() {
        errors++;
    }

    public int getErrors() {
        return errors;
    }

    public StringBuilder getCurrentStateOfTheWord() {
        return currentStateOfTheWord;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }
}
