package model;

public class Room implements IRoom{
    public String roomNumber;
    public Double price;
    public RoomType enumeration;

    @Override
    public String getRoomNumber() {
        return null;
    }

    @Override
    public Double getRoomDouble() {
        return Double.valueOf(0);
    }

    @Override
    public RoomType getRoomType() {
        return null;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", enumeration=" + enumeration +
                '}';
    }
}
