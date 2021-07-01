package model;

import java.util.Date;

public class Reservation {
    private final Customer customer;
    private final IRoom room;
    private final Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void updateCheckOut(Date newDate) {
        this.checkOutDate = newDate;
    }

    public boolean isChronological(Date checkInDate, Date checkOutDate) {
        return getCheckInDate().compareTo(checkOutDate) > 0 ||
                getCheckOutDate().compareTo(checkInDate) < 1;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "customer=" + customer +
                ", room=" + room +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
}
