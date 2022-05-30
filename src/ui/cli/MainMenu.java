package ui.cli;

import service.CustomerService;

import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    static CustomerService customerService = CustomerService.getInstance();
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
                case "1": // Find and reserve a room
                    //System.out.println("Call method to reserve room");
                    System.out.println("Enter CheckIn date mm/dd/yyyy example 30/05/2022:");
                    String checkInDate = scanner.nextLine();
                    System.out.println("Enter CheckOut date mm/dd/yyyy example 02/06/2022:");
                    String checkOutDate = scanner.nextLine();
                    System.out.println(customerService.getAllRooms());
                    System.out.println("Would you like to book a room? y/n");
                    String bookRoom = scanner.nextLine();
                    if (bookRoom.equals("y")){
                        System.out.println("Do you have an account with us? y/n");
                        String hasAccount = scanner.nextLine();
                        if (hasAccount.equals("y")){
                            System.out.println("Enter your Email format: joe@mail.com");
                            String customerEmail = scanner.nextLine();
                            System.out.println(customerService.getCustomer(customerEmail));
                            customerService.toString();
                        }
                    }
                    break;
                case "2": // See my reservation
                    System.out.println("Call method to see reservation");
                    break;
                case "3": // Create an account
                    System.out.println("First Name:");
                    String firstName = scanner.nextLine();
                    System.out.println("Last Name:");
                    String lastName = scanner.nextLine();
                    while(true){
                        System.out.println("Email:");
                        String email = scanner.nextLine();
                        try{
                            customerService.addCustomer(email, firstName, lastName);
                            break;
                        }catch (IllegalArgumentException e){
                            System.out.println("The email format is not correct, please add a valid email");
                        }
                    }

                    break;
                case "4": // Admin Menu
                    AdminMenu.menu();
                case "5": // Exit
                    run = false;
                    break;
                default:
                    System.out.println("Choice must be between 1 and 5");

            }
        }
    }

}
