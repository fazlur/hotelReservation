package service;

import model.Customer;
import model.IRoom;
import model.Room;

import java.util.*;

public class CustomerService {

    ArrayList<Customer> customerArrayList = new ArrayList<>();
    Map<String, Customer> mapOfCustomers = new HashMap<>();
    private static CustomerService customerService;
    ReservationService room = ReservationService.getInstance();

    private CustomerService() {
    }

    /*
        Making customerService a singleton
        Note that the variable customerService is made static so it can
        only be instantiated from this class
     */
    public static CustomerService getInstance() {
        if (customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }

    public void addCustomer(String email, String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName, email);
        customerArrayList.add(customer);
    }

    //Creating hashmap where customer email is key for customer details
    public Customer getCustomer(String customerEmail) {

        for (Customer c : customerArrayList) {
            mapOfCustomers.put(c.getEmail(), c);
        }
        return mapOfCustomers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers() {
        return customerArrayList;
    }

    //Communication with ReservationService
    //public void addRoom(List<Room> rooms)
    public void addRoom(Room rooms) {
        //rooms.forEach(room::addRoom); // Troca de mensagem
        room.addRoom(rooms);
    }

    public Collection<IRoom> getAllRooms() {
        return room.getAllRooms();
    }


    public void displayAllReservations() {
        room.printAllReservation();
    }
}
