package service;

import model.Customer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides services related to customers.
 * @author Haregweyni Temanu
 */
public class CustomerService {

    // Singleton instance of the CustomerService class
    private static final CustomerService SINGLETON = new CustomerService();

    // Map to store customers with their email as the key
    private final Map<String, Customer> customers = new HashMap<>();

    // Private constructor to prevent instantiation from outside the class
    private CustomerService() {}

    // Getter for the singleton instance of CustomerService
    public static CustomerService getSingleton() {
        return SINGLETON;
    }

    // Add a new customer to the customers map
    public void addCustomer(final String email, final String firstName, final String lastName) {
        customers.put(email, new Customer(firstName, lastName, email));
    }

    // Get a customer by their email
    public Customer getCustomer(final String customerEmail) {
        return customers.get(customerEmail);
    }

    // Get all customers as a collection
    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
