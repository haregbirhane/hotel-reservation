package model;

import java.util.Date;

/**
 * Represents a reservation with customer, room, check-in date, and check-out date.
 *
 * @author Haregweyni Temanu
 */
public class Reservation {

    private final Customer customer;
    private final IRoom room;
    private final Date checkInDate;
    private final Date checkOutDate;

    /**
     * Creates a reservation with the given customer, room, check-in date, and check-out date.
     *
     * @param customer The customer making the reservation.
     * @param room The room being reserved.
     * @param checkInDate The check-in date for the reservation.
     * @param checkOutDate The check-out date for the reservation.
     */
    public Reservation(final Customer customer, final IRoom room,
                       final Date checkInDate, final Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    /**
     * Returns the reserved room.
     *
     * @return The room being reserved.
     */
    public IRoom getRoom() {
        return this.room;
    }

    /**
     * Returns the check-in date for the reservation.
     *
     * @return The check-in date.
     */
    public Date getCheckInDate() {
        return this.checkInDate;
    }

    /**
     * Returns the check-out date for the reservation.
     *
     * @return The check-out date.
     */
    public Date getCheckOutDate() {
        return this.checkOutDate;
    }

    /**
     * Returns a string representation of the reservation.
     *
     * @return A string representation of the reservation.
     */
    @Override
    public String toString() {
        return "Customer: " + this.customer.toString()
                + "\nRoom: " + this.room.toString()
                + "\nCheckIn Date: " + this.checkInDate
                + "\nCheckOut Date: " + this.checkOutDate;
    }
}
