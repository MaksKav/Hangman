package com.maxkavun.hangman;


/*
    Responsible for displaying the state of the hangman and the progress of the game.
 */
public class HangmanDisplay {

    private GameState gameState;
    private final String[] hangmanStages = {
                    "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",

                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",

                    "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========="
    };

    public HangmanDisplay(GameState gameState) {
        this.gameState = gameState;
    }

    public void drawHangman(){
        int counter = gameState.getErrors();
        switch (counter){
            case 0 -> System.out.println(hangmanStages[0]);
            case 1 -> System.out.println(hangmanStages[1]);
            case 2 -> System.out.println(hangmanStages[2]);
            case 3 -> System.out.println(hangmanStages[3]);
            case 4 -> System.out.println(hangmanStages[4]);
            case 5 -> System.out.println(hangmanStages[5]);
            case 6 -> System.out.println(hangmanStages[6]);
        }
    }
}
