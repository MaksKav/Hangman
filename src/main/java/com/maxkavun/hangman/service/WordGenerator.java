package main.java.com.maxkavun.hangman.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static main.java.com.maxkavun.hangman.Main.language;

/*
    The WordGenerator class is responsible for selecting a random randomWord
    from a predefined list of words for the player to guess.
    This class encapsulates the logic for loading and choosing words,
    ensuring that the game has a randomWord to use during each session.
 */

public class WordGenerator {
    private String randomWord;

    public WordGenerator() {
        loadWord();
    }

    public void loadWord() {
        Path path;
        List<String> words = new ArrayList<>();
        try {
            if (language.equals("eng")) {
                 path = Path.of("src", "com/maxkavun/hangman/resources/words_ENG.txt");
            } else {
                 path = Path.of("src", "com/maxkavun/hangman/resources/words_UKR.txt");
            }

            words = Files.readAllLines(path);
            Random rand = new Random();
            int i = rand.nextInt(words.size());
            randomWord = words.get(i);
        } catch (IOException e) {
            System.out.println("Problem in the class --WordGenerator--, problem with finding a random randomWord.");
            throw new RuntimeException(e);
        }
        if (randomWord == null || randomWord.isEmpty()) {
            throw new IllegalStateException("Problem in the class --WordGenerator--, problem with finding a random randomWord.");
        }
    }

    public String getRandomWord() {
        return randomWord;
    }

}
