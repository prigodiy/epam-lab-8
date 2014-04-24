package epam.students.prihodii.types;

/**
 * This enum provides a types of card with expiration date.
 *
 * @author Nickolay Prihodii
 */

public enum TimeCardType {

    TEN_DAYS(10),
    MONTH(30);

    private int daysLeft;

    private TimeCardType(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public int getDaysLeft() {
        return daysLeft;
    }
}
