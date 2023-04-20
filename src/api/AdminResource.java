package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;

/**
 * Provides administrative functionalities for managing customers, rooms, and reservations.
 *
 * @author Haregeweyni Temanu
 */
public class AdminResource {

    private static final AdminResource SINGLETON = new AdminResource();

    private final CustomerService customerService = CustomerService.getSingleton();
    private final ReservationService reservationService = ReservationService.getSingleton();

    /**
     * Private constructor to ensure singleton pattern.
     */
    private AdminResource() {}

    /**
     * Returns the singleton instance of the AdminResource.
     *
     * @return The singleton instance of AdminResource.
     */
    public static AdminResource getSingleton() {
        return SINGLETON;
    }

    /**
     * Adds a list of rooms to the system.
     *
     * @param rooms The list of rooms to add.
     */
    public void addRoom(List<IRoom> rooms) {
        rooms.forEach(reservationService::addRoom);
    }

    /**
     * Retrieves all rooms in the system.
     *
     * @return A collection of all rooms.
     */
    public Collection<IRoom> getAllRooms() {
        return reservationService.getAllRooms();
    }

    /**
     * Retrieves all customers in the system.
     *
     * @return A collection of all customers.
     */
    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     * Displays all reservations in the system.
     */
    public void displayAllReservations() {
        reservationService.printAllReservation();
    }
}
