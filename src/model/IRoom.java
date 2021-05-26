package model;

public interface IRoom {
    String getRoomNumber();
    Double getRoomDouble();
    RoomType getRoomType();
    boolean isFree();
}
