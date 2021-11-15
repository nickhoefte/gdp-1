import gmbh.kdb.hsw.gdp.Game;

import java.util.Scanner;

public class MainMenu {

    private Scanner sc = new Scanner(System.in);
    private String choice = "";

    public void displayMenu() {

        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.println("MENU:");
        System.out.println("Please choose one of the following:");
        System.out.println("(1) Quit game");
        System.out.println("(2) Next round");

        choice = sc.nextLine();

        switch (choice) {
            case "1": {
                Game.get().
                System.out.println("Game was abandoned!");
                break;
            }
            case "2": {
                System.out.println("Next Round started!");
                break;
            }
            default: {
                System.out.println(ANSI_RED + "Please choose a valid number!" + ANSI_RESET);
                displayMenu();
                break;
            }
        }
    }
}