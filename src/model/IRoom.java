package model;

/**
 * Represents a room interface with room number, room price, room type, and free status.
 *
 * @author Haregweyni Temanu
 */
public interface IRoom {

    /**
     * Returns the room number.
     *
     * @return The room number.
     */
    public String getRoomNumber();

    /**
     * Returns the room price.
     *
     * @return The room price.
     */
    public Double getRoomPrice();

    /**
     * Returns the room type.
     *
     * @return The room type.
     */
    public RoomType getRoomType();

    /**
     * Returns whether the room is free or not.
     *
     * @return true if the room is free, false otherwise.
     */
    public boolean isFree();
}
