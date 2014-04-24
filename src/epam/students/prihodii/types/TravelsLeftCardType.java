package epam.students.prihodii.types;

/**
 * This enum provides a types of card with remaining passes.
 *
 * @author Nickolay Prihodii
 */

public enum TravelsLeftCardType {

    FIVE(5),
    TEN(10);

    private int tripsLeft;

    private TravelsLeftCardType(int tripsLeft) {
        this.tripsLeft = tripsLeft;
    }

    public int getTravelsLeft() {
        return tripsLeft;
    }
}
