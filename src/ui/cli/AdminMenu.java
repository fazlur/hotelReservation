package ui.cli;

import api.AdminResource;
import model.Room;
import model.RoomType;
import service.ReservationService;
import service.CustomerService;

import java.util.Scanner;

public class AdminMenu {
    static ReservationService roomService = ReservationService.getInstance();
    static AdminResource adminResource = AdminResource.getInstance();
    static Scanner scanner = new Scanner(System.in);
    static String topAndBottom = "-------------------------------------------------";

    public static void main(String[] args) {
        new AdminMenu().menu();
    }

    static void menu() {
        boolean run = true;

        while (run){
            System.out.println(topAndBottom);
            System.out.println("1. See all customers");
            System.out.println("2. See all rooms");
            System.out.println("3. See all reservations");
            System.out.println("4. Add a room");
            System.out.println("5. Back to Main Menu");
            System.out.println(topAndBottom);

            String userInput = scanner.nextLine();

            switch (userInput){
                case "1": // Show all customers
                    //System.out.println("Call method to show all customers");
                    System.out.println(adminResource.getAllCustomers());
                    break;
                case "2": // Show all rooms
                    System.out.println(adminResource.getAllRooms());
                    break;
                case "3": // Show all reservations
                    System.out.println("Call method to show all reservations");
                    break;
                case "4": // Add room
                    System.out.println("Room Number:");
                    String roomNumber = scanner.nextLine();
                    System.out.println("Room price:");
                    Double price = Double.valueOf(scanner.nextLine());
                    RoomType roomType;
                    while(true){
                        System.out.println("Is this room 1.Single or 2.Double");
                        String roomSize = scanner.nextLine();
                        if (roomSize.equals("1")){
                            roomType = RoomType.SINGLE;
                            break;
                        }else if(roomSize.equals("2")){
                            roomType = RoomType.DOUBLE;
                            break;
                        }else{
                            System.out.println("Please choose 1 or 2");
                        }
                    }
                    //TODO - review why in admin resource it cannot take this
                    Room newRoom = new Room(roomNumber,price, roomType);
                    adminResource.addRoom(newRoom);
                    break;
                case "5": // Back to main menu
                    MainMenu.menu();
                    run = false;
                    break;
                default:
                    System.out.println("Choice must be between 1 and 5");

            }
        }
    }
}
