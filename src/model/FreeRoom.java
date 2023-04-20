package model;

/**
 * Represents a free room with a room number and room type.
 *
 * @author Haregweyni Temanu
 */
public class FreeRoom extends Room {

    /**
     * Creates a free room with the given room number and room type.
     *
     * @param roomNumber The room number of the free room.
     * @param enumeration The room type (single bed or double bed) of the free room.
     */
    public FreeRoom(final String roomNumber, final RoomType enumeration) {
        super(roomNumber, 0.0, enumeration);
    }

    /**
     * Returns a string representation of the free room.
     *
     * @return A string representation of the free room.
     */
    @Override
    public String toString() {
        return "FreeRoom => " + super.toString();
    }

}
