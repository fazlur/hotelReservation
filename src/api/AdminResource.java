package api;

import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    private static AdminResource adminResource;
    CustomerService customer = CustomerService.getInstance();


    private AdminResource(){
        super();
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

    public Collection<Customer> getAllCustomers(){
        return customer.getAllCustomers();
    }

    public Collection<IRoom> getAllRooms(){
        return customer.getAllRooms();
    }

    public void addRoom(Room rooms){
        customer.addRoom(rooms);
    }
}
