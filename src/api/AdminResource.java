package api;

import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdminResource {
    private static AdminResource adminResource;
    CustomerService customer = CustomerService.getInstance();
    ReservationService room = ReservationService.getInstance();

    private AdminResource(){
    }

    public static AdminResource getInstance(){
        if(adminResource == null){
            adminResource = new AdminResource();
        }
        return adminResource;
    }

    public Customer getCustomer(String email){
        return customer.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms){
        for (IRoom i : rooms){
            room.addRoom(i);
        }
    }

    //TODO - Change as this is not returning nothing, to see how to get this from ReservationService
    public Collection<IRoom> getAllRooms(){
        return null;
    }

    public Collection<Customer> getAllCustomers(){
        return customer.getAllCustomers();
    }

    public void displayAllReservations(){
        room.printAllReservation();
    }
}
