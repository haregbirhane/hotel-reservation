package model;

import java.util.Objects;

/**
 * Represents a room with a room number, price, and room type.
 *
 * @author Haregweyni Temanu
 */
public class Room implements IRoom {

    private final String roomNumber;
    private final Double price;
    private final RoomType enumeration;

    /**
     * Creates a room with the given room number, price, and room type.
     *
     * @param roomNumber The room number.
     * @param price The price of the room.
     * @param enumeration The room type.
     */
    public Room(final String roomNumber, final Double price, final RoomType enumeration) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }

    /**
     * Returns the room number.
     *
     * @return The room number.
     */
    public String getRoomNumber() {
        return this.roomNumber;
    }

    /**
     * Returns the room price.
     *
     * @return The room price.
     */
    public Double getRoomPrice() {
        return this.price;
    }

    /**
     * Returns the room type.
     *
     * @return The room type.
     */
    public RoomType getRoomType() {
        return this.enumeration;
    }

    /**
     * Returns whether the room is free.
     *
     * @return True if the room is free, false otherwise.
     */
    public boolean isFree() {
        return this.price != null && this.price.equals(0.0);
    }

    /**
     * Returns a string representation of the room.
     *
     * @return A string representation of the room.
     */
    @Override
    public String toString() {
        return "Room Number: " + this.roomNumber
                + " Price: $" + this.price
                + " Enumeration: " + this.enumeration;
    }

    /**
     * Determines if two rooms are equal based on their room numbers.
     *
     * @param obj The object to compare to this room.
     * @return True if the rooms are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }

        if(!(obj instanceof Room)) {
            return false;
        }

        final Room room = (Room) obj;
        return Objects.equals(this.roomNumber, room.roomNumber);
    }

    /**
     * Returns a hash code value for this room.
     *
     * @return A hash code value for this room.
     */
    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}
