package ui.cli;

import java.util.Scanner;

public class MainMenu {
    static Scanner scanner = new Scanner(System.in);
    static String topAndBottom = "-------------------------------------------------";

    public static void main(String[] args) {
        new MainMenu().menu();
    }

    public static void menu(){
        boolean run = true;

        while (run) {
            System.out.println(topAndBottom);
            System.out.println("1. Find and reserve a room");
            System.out.println("2. See my reservation");
            System.out.println("3. Create an account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            System.out.println(topAndBottom);

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    System.out.println("Call method to reserve room");
                    break;
                case "2":
                    System.out.println("Call method to see reservation");
                    break;
                case "3":
                    System.out.println("Method to create account");
                    break;
                case "4":
                    AdminMenu.menu();
                case "5":
                    run = false;
                    break;
                default:
                    System.out.println("Choice must be between 1 and 5");

            }
        }
    }

}
