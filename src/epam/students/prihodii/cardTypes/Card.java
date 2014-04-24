package epam.students.prihodii.cardTypes;

import epam.students.prihodii.types.OwnerCardType;

/**
 * This class provides a skeletal implementation of the <tt>Card</tt>
 * classes, to minimize the effort required to extends this class.
 *
 * @author Nickolay Prihodii
 */

public abstract class Card {

    /**
     * The ID of the Card.
     */
    private long id;

    /**
     * Type of card owner (Adult, student etc.).
     */
    private OwnerCardType ownerType;

    /**
     * Sole constructor. (For invocation by subclass constructors)
     *
     * @param id        card id
     * @param ownerType type of card owner
     */
    public Card(long id, OwnerCardType ownerType) {
        this.id = id;
        this.ownerType = ownerType;
    }

    /**
     * Returns card id.
     */
    public long getId() {
        return id;
    }

    /**
     * Returns type of card owner.
     */
    public OwnerCardType getOwnerType() {
        return ownerType;
    }

    /**
     * Returns true if card acceptable and false if not.
     */
    public abstract boolean accept();

    /**
     * Returns a string representation of the card parameters
     * (For invocation by subclass toString methods)
     *
     * @return a string representation of the card.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CARD_ID: ")
                .append(getId())
                .append(" CARD_OWNER: ")
                .append(getOwnerType().name());
        return sb.toString();
    }
}