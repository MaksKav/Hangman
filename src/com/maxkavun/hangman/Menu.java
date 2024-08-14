package com.maxkavun.hangman;

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


    public  void firstDisplayMenu() {
        System.out.println("Welcome to Hangman");
        System.out.println("Please enter your name");
        player.setPlayerName(scanner.nextLine());
    }


    public void secondDisplayMenu() {
        System.out.println("Please choose one of the following options:");
        System.out.println("1. New game");
        System.out.println("2. Quit");
    }

    public int secondDisplayMenuChoice (){
        boolean bool = true ;
        int choice = 0 ;
        while(bool) {
            choice = scanner.nextInt();
            scanner.nextLine();
            if(choice == 1 || choice == 2) {
                bool = false ;
            }else {
                System.out.println("You entered an incorrect command. Please choose 1 or 2");
            }
        }
        return choice ;
    }









}
