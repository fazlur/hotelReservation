package model;

public class FreeRoom extends Room{
    public FreeRoom() {
        super();
        price = Double.valueOf(0);
    }

    @Override
    public String toString() {
        return "FreeRoom{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", enumeration=" + enumeration +
                '}';
    }
}
