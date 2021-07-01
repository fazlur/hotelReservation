package service;


import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService { // Definition
    // State
    private Map<String, Room> mapOfRooms = new HashMap<>();
    private ArrayList<IRoom> roomArrayList = new ArrayList<>();
    private ArrayList<Reservation> reservationArrayList = new ArrayList<>();

    private ReservationService() {
        super();
    }

    //Making a static reference - making ReservationService a singleton
    private static ReservationService reservationService;
    public static ReservationService getInstance(){
        if(reservationService == null){
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    public void addRoom(IRoom room){
        Room newRoom = (Room) room;
        roomArrayList.add(newRoom);
        mapOfRooms.put(room.getRoomNumber(),newRoom);
    }

    public IRoom getARoom(String roomId){
        return mapOfRooms.get(roomId);
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation newReservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservationArrayList.add(newReservation);
        return  newReservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> emptyRooms = new ArrayList<>();
        for (Reservation empty : reservationArrayList){
            if (empty.isChronological(checkInDate, checkOutDate)){
                emptyRooms.add(empty.getRoom());

            }
        }
        return  emptyRooms;

    }

    //TODO - Check what should be returned here (i.e. customer name + dates)
    public Collection<Reservation> getCustomerReservation(Customer customer){
        Collection<Reservation> customerReservationList = new ArrayList<>();
        for (Reservation customerReservation : reservationArrayList){
            if (customerReservation.getCustomer() == customer){
                customerReservationList.add(customerReservation);
            }
        }
        return customerReservationList;
    }

    public void printAllReservation(){
        System.out.println(reservationArrayList);
    }

    public Collection<IRoom> getAllRooms() {
        return roomArrayList;
    }
}
