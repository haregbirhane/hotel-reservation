package model;

/**
 * Represents the type of room: single or double.
 *
 * @author Haregweyni Temanu
 */
public enum RoomType {
    SINGLE("1"),
    DOUBLE("2");

    public final String label;

    /**
     * Constructs a RoomType with the specified label.
     *
     * @param label The label for this RoomType.
     */
    private RoomType(String label) {
        this.label = label;
    }

    /**
     * Returns the RoomType corresponding to the given label.
     *
     * @param label The label to find the corresponding RoomType.
     * @return The RoomType that matches the label.
     * @throws IllegalArgumentException If the label does not match any RoomType.
     */
    public static RoomType valueOfLabel(String label) {
        for (RoomType roomType : values()) {
            if (roomType.label.equals(label)) {
                return roomType;
            }
        }
        throw new IllegalArgumentException();
    }
}
