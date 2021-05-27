package service;


import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {
    Map<String, Room> mapOfRooms = new HashMap<>();
    ArrayList<Room> roomArrayList = new ArrayList<>();
    ArrayList<Reservation> reservationArrayList = new ArrayList<>();

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
            if (empty.getCheckInDate().compareTo(checkOutDate) > 0 ||
                    empty.getCheckOutDate().compareTo(checkInDate ) < 1 ){
                emptyRooms.add(empty.getRoom());

            }
        }
        return  emptyRooms;

    }
}
