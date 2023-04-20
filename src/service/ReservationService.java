package service;

import model.Customer;
import model.Reservation;
import model.IRoom;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class provides services related to reservations.
 * @author Haregweyni Temanu
 */
public class ReservationService {

    // Singleton instance of the ReservationService class
    private static final ReservationService SINGLETON = new ReservationService();
    // Default number of days for alternative room search
    private static final int RECOMMENDED_ROOMS_DEFAULT_PLUS_DAYS = 7;

    // Maps to store rooms and reservations
    private final Map<String, IRoom> rooms = new HashMap<>();
    private final Map<String, Collection<Reservation>> reservations = new HashMap<>();

    // Private constructor to prevent instantiation from outside the class
    private ReservationService() {
    }

    // Getter for the singleton instance of ReservationService
    public static ReservationService getSingleton() {
        return SINGLETON;
    }

    // Add a room to the rooms map
    public void addRoom(final IRoom room) {
        rooms.put(room.getRoomNumber(), room);
    }

    // Get a room by its room number
    public IRoom getARoom(final String roomNumber) {
        return rooms.get(roomNumber);
    }

    // Get all rooms as a collection
    public Collection<IRoom> getAllRooms() {
        return rooms.values();
    }

    // Reserve a room for a customer between check-in and check-out dates
    public Reservation reserveARoom(final Customer customer, final IRoom room,
                                    final Date checkInDate, final Date checkOutDate) {
        final Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);

        Collection<Reservation> customerReservations = getCustomersReservation(customer);

        if (customerReservations == null) {
            customerReservations = new LinkedList<>();
        }

        customerReservations.add(reservation);
        reservations.put(customer.getEmail(), customerReservations);

        return reservation;
    }

    // Find available rooms between check-in and check-out dates
    public Collection<IRoom> findRooms(final Date checkInDate, final Date checkOutDate) {
        return findAvailableRooms(checkInDate, checkOutDate);
    }

    // Find alternative available rooms for a given date range
    public Collection<IRoom> findAlternativeRooms(final Date checkInDate, final Date checkOutDate) {
        return findAvailableRooms(addDefaultPlusDays(checkInDate), addDefaultPlusDays(checkOutDate));
    }

    // Helper method to find available rooms for a given date range
    private Collection<IRoom> findAvailableRooms(final Date checkInDate, final Date checkOutDate) {
        final Collection<Reservation> allReservations = getAllReservations();
        final Collection<IRoom> notAvailableRooms = new LinkedList<>();

        for (Reservation reservation : allReservations) {
            if (reservationOverlaps(reservation, checkInDate, checkOutDate)) {
                notAvailableRooms.add(reservation.getRoom());
            }
        }

        return rooms.values().stream().filter(room -> notAvailableRooms.stream()
                        .noneMatch(notAvailableRoom -> notAvailableRoom.equals(room)))
                .collect(Collectors.toList());
    }

    // Add default days to a date
    public Date addDefaultPlusDays(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, RECOMMENDED_ROOMS_DEFAULT_PLUS_DAYS);

        return calendar.getTime();
    }

    // Check if a reservation overlaps with given check-in and check-out dates
// Check if a reservation overlaps with given check-in and check-out dates
    private boolean reservationOverlaps(final Reservation reservation, final Date checkInDate,
                                        final Date checkOutDate) {
        return checkInDate.before(reservation.getCheckOutDate())
                && checkOutDate.after(reservation.getCheckInDate());
    }

    // Get all reservations of a customer
    public Collection<Reservation> getCustomersReservation(final Customer customer) {
        return reservations.get(customer.getEmail());
    }

    // Print all reservations
    public void printAllReservation() {
        final Collection<Reservation> reservations = getAllReservations();

        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation + "\n");
            }
        }
    }

    // Get all reservations as a collection
    private Collection<Reservation> getAllReservations() {
        final Collection<Reservation> allReservations = new LinkedList<>();

        for (Collection<Reservation> reservations : reservations.values()) {
            allReservations.addAll(reservations);
        }

        return allReservations;
    }
}