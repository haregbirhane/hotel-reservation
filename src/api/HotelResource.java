package api;

import model.Customer;
import model.Reservation;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * Provides hotel-related functionalities for managing customers, rooms, and reservations.
 *
 * @author Haregweyni Temanu
 */
public class HotelResource {

    private static final HotelResource SINGLETON = new HotelResource();

    private final CustomerService customerService = CustomerService.getSingleton();
    private final ReservationService reservationService = ReservationService.getSingleton();

    /**
     * Private constructor to ensure singleton pattern.
     */
    private HotelResource() {
    }

    /**
     * Returns the singleton instance of the HotelResource.
     *
     * @return The singleton instance of HotelResource.
     */
    public static HotelResource getSingleton() {
        return SINGLETON;
    }

    /**
     * Retrieves a customer by email.
     *
     * @param email The email of the customer.
     * @return The customer with the provided email, or null if not found.
     */
    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    /**
     * Creates a new customer with the provided email, first name, and last name.
     *
     * @param email     The email of the new customer.
     * @param firstName The first name of the new customer.
     * @param lastName  The last name of the new customer.
     */
    public void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
    }

    /**
     * Retrieves a room by room number.
     *
     * @param roomNumber The room number.
     * @return The room with the provided room number, or null if not found.
     */
    public IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    /**
     * Books a room for a customer by email, room, check-in date, and check-out date.
     *
     * @param customerEmail The email of the customer.
     * @param room          The room to be booked.
     * @param checkInDate   The check-in date.
     * @param checkOutDate  The check-out date.
     * @return The created reservation.
     */
    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return reservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    /**
     * Retrieves the reservations for a customer by email.
     *
     * @param customerEmail The email of the customer.
     * @return A collection of reservations for the customer, or an empty collection if the customer is not found.
     */
    public Collection<Reservation> getCustomersReservations(String customerEmail) {
        final Customer customer = getCustomer(customerEmail);

        if (customer == null) {
            return Collections.emptyList();
        }

        return reservationService.getCustomersReservation(getCustomer(customerEmail));
    }

    /**
     * Searches for available rooms within the given check-in and check-out dates.
     *
     * @param checkIn  The check-in date.
     * @param checkOut The check-out date.
     * @return A collection of available rooms.
     */
    public Collection<IRoom> findARoom(final Date checkIn, final Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }

    /**
     * Searches for alternative available rooms within the given check-in and check-out dates.
     *
     * @param checkIn  The check-in date.
     * @param checkOut The
     *                 check-out date.
     * @return A collection of alternative available rooms.
     */
    public Collection<IRoom> findAlternativeRooms(final Date checkIn, final Date checkOut) {
        return reservationService.findAlternativeRooms(checkIn, checkOut);
    }

    /**
     * Adds default days to the provided date.
     *
     * @param date The date to add default days to.
     * @return The date with default days added.
     */
    public Date addDefaultPlusDays(final Date date) {
        return reservationService.addDefaultPlusDays(date);
    }
}