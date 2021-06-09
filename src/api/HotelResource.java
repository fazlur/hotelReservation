package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    private static HotelResource hotelResource;
    CustomerService customer = CustomerService.getInstance();
    ReservationService reservation = ReservationService.getInstance();

    private HotelResource() {
    }

    public static HotelResource getInstance() {
        if (hotelResource == null) {
            hotelResource = new HotelResource();
        }
        return hotelResource;
    }

    public Customer getCustomer(String email){
        return customer.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName){
        customer.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber){
        return reservation.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        return reservation.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomersReservations(String customerEmail){
        return reservation.getCustomerReservation(getCustomer(customerEmail));
    }

    public Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate){
        return reservation.findRooms(checkInDate, checkOutDate);
    }

}
