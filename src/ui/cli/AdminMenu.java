package ui.cli;

import model.Room;
import model.RoomType;
import service.ReservationService;

import java.util.Scanner;

public class AdminMenu {
    static ReservationService roomService = ReservationService.getInstance();
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
                case "1":
                    System.out.println("Call method to show all customers");
                    break;
                case "2":
                    System.out.println("Call method to show all rooms");
                    System.out.println(roomService.getAllRooms());
                    //roomService.getAllRooms();
                    break;
                case "3":
                    System.out.println("Call method to show all reservations");
                    break;
                case "4":
                    System.out.println("Room Number:");
                    String roomNumber = scanner.nextLine();
                    System.out.println("Room price:");
                    Double price = Double.valueOf(scanner.nextLine());
                    Room newRoom = new Room(roomNumber,price, RoomType.SINGLE);
                    roomService.addRoom(newRoom);
                    break;
                case "5":
                    MainMenu.menu();
                default:
                    System.out.println("Choice must be between 1 and 5");

            }
        }
    }
}
