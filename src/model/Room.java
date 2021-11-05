package model;

public class Room implements IRoom{
    public String roomNumber;
    public Double price;
    public RoomType enumeration;

    public Room(String roomNumber, Double price, RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }


    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return Double.valueOf(0);
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    //TODO - Cleanup print
    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + "\n" +
                "price=" + price + "\n" +
                "enumeration=" + enumeration + "\n" +
                '}';
    }
}
