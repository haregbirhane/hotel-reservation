package model;

import java.util.regex.Pattern;

/**
 * Represents a customer with first name, last name and email address.
 *
 * @author Haregweyni Temanu
 */
public class Customer {

    private static final String EMAIL_REGEX_PATTERN = "^(.+)@(.+).(.+)$";

    private final String firstName;
    private final String lastName;
    private final String email;

    /**
     * Creates a customer with the given first name, last name and email.
     *
     * @param firstName The first name of the customer.
     * @param lastName  The last name of the customer.
     * @param email     The email address of the customer.
     */
    public Customer(final String firstName, final String lastName, final String email) {
        this.isValidEmail(email);

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Checks if the given email is valid using a regular expression pattern.
     *
     * @param email The email address to check.
     * @throws IllegalArgumentException If the email is invalid.
     */
    private void isValidEmail(final String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);

        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    /**
     * Returns the email address of the customer.
     *
     * @return The email address of the customer.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Returns a string representation of the customer.
     *
     * @return A string representation of the customer.
     */
    @Override
    public String toString() {
        return "First Name: " + this.firstName
                + " Last Name: " + this.lastName
                + " Email: " + this.email;
    }
}
