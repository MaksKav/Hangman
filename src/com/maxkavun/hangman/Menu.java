package com.maxkavun.hangman;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.maxkavun.hangman.Strings.getStrings;

/*
    This class responsible for displaying and handling the main menu.
 */
public class Menu {

    private Player player;
    private Scanner scanner;

    public Menu(Scanner scanner, Player player) {
        this.scanner = scanner;
        this.player = player;
    }


    public void firstDisplayMenu() {
        System.out.println(getStrings("welcome"));
        System.out.println(getStrings("enter_name"));
        player.setPlayerName(scanner.nextLine());
    }


    public void secondDisplayMenu() {
        System.out.println(getStrings("choose_option"));
        System.out.println(getStrings("new_game"));
        System.out.println(getStrings("quit"));
    }

    public int secondDisplayMenuChoice() {
        boolean bool = true;
        int choice = 0;

        while (bool) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1 || choice == 2) {
                    bool = false;
                } else {
                    System.out.println(getStrings("incorrect_command"));
                }
            } catch (InputMismatchException e) {
                System.out.println(getStrings("incorrect_command"));
                scanner.nextLine();
            }
        }
        return choice;
    }
}
