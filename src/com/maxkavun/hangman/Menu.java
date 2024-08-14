package com.maxkavun.hangman;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
    This class responsible for displaying and handling the main menu.
 */
public class Menu {

    private Player player;
    private Scanner scanner ;

    public Menu(Scanner scanner , Player player) {
        this.scanner = scanner;
        this.player = player;
    }



    public  void firstDisplayMenu_Eng() {
        System.out.println("Welcome to Hangman");
        System.out.println("Please enter your name");
        player.setPlayerName(scanner.nextLine());
    }


    public void secondDisplayMenu_Eng() {
        System.out.println("Please choose one of the following options:");
        System.out.println("1. New game");
        System.out.println("2. Quit");
    }

    public int secondDisplayMenuChoice_Eng(){
        boolean bool = true ;
        int choice = 0 ;

        while(bool) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if(choice == 1 || choice == 2) {
                    bool = false ;
                }else {
                    System.out.println("You entered an incorrect command. Please choose 1 or 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("You entered an incorrect command. Please choose 1 or 2");
                scanner.nextLine();
            }
        }
        return choice ;
    }


    // Methods for ukrainian languages


    public  void firstDisplayMenu_Ukr() {
        System.out.println("Вітаю в Шибениці");
        System.out.println("Будь ласка напишіть своє їм'я");
        player.setPlayerName(scanner.nextLine());
    }


    public void secondDisplayMenu_Ukr() {
        System.out.println("Будь ласка, оберіть одну з наступних опцій:");
        System.out.println("1. Нова гра");
        System.out.println("2. Вийти");
    }


    public int secondDisplayMenuChoice_Ukr() {
        boolean bool = true;
        int choice = 0;

        while (bool) {
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1 || choice == 2) {
                    bool = false;
                } else {
                    System.out.println("Ви ввели неправильну команду. Будь ласка, оберіть 1 або 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ви ввели неправильну команду. Будь ласка, оберіть 1 або 2");
                scanner.nextLine();
            }
        }
        return choice;
    }


}
