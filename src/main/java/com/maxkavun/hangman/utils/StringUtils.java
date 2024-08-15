package main.java.com.maxkavun.hangman.utils;

import java.util.HashMap;
import java.util.Map;

/*This class is designed to store the game strings based on the language selected by the user.*/

public class StringUtils {
    private static Map<String, String> strings;

    static {
        strings = new HashMap<>();
    }

    public static void loadLocalization(String language) {
        if (strings.isEmpty()) {
            if (language.equals("eng")) {
                strings.put("welcome", "Welcome to Hangman");
                strings.put("enter_name", "Please enter your name");
                strings.put("choose_option", "Please choose one of the following options:");
                strings.put("new_game", "1. New game");
                strings.put("quit", "2. Quit");
                strings.put("enter_letter", "Enter a letter");
                strings.put("already_entered", "You've already entered this letter, please try again");
                strings.put("incorrect_command", "You entered an incorrect command. Please choose 1 or 2");
                strings.put("win", "Congratulations! You won!");
                strings.put("lose", "Oh, you lost. The correct word was --> ");
                strings.put("final_score", "Your final score is:");
                strings.put("win_count", "Win: ");
                strings.put("lose_count", "Lose: ");
                strings.put("thank_you", "Thank you for playing '");
                strings.put("see_you", "' see you next time!");
                strings.put("mistakes", "Mistakes: ");
                strings.put("one_letter", "Please enter only one letter.");
            } else {
                strings.put("welcome", "Вітаю в Шибениці");
                strings.put("enter_name", "Будь ласка напишіть своє їм'я");
                strings.put("choose_option", "Будь ласка, оберіть одну з наступних опцій:");
                strings.put("new_game", "1. Нова гра");
                strings.put("quit", "2. Вийти");
                strings.put("enter_letter", "Введіть літеру");
                strings.put("already_entered", "Ви вже вводили цю літеру , спробуйте знову");
                strings.put("incorrect_command", "Ви ввели неправильну команду. Будь ласка, оберіть 1 або 2");
                strings.put("win", "Вітаємо! Ви виграли!");
                strings.put("lose", "На жаль, ви програли. Правильне слово було --> ");
                strings.put("final_score", "Ваш остаточний рахунок:");
                strings.put("win_count", "Перемог: ");
                strings.put("lose_count", "Поразок: ");
                strings.put("thank_you", "Дякуємо за гру '");
                strings.put("see_you", "' побачимось наступного разу!");
                strings.put("mistakes", "Помилок: ");
                strings.put("one_letter", "Будь ласка введіть тільки одну літеру.");

            }
        }
    }

    public static String getStrings(String key) {
        return strings.get(key);
    }
}
