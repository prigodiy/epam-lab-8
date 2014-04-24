package epam.students.prihodii.cardTypes;

import epam.students.prihodii.types.OwnerCardType;
import epam.students.prihodii.types.TravelsLeftCardType;

/**
 * This class provides a implementation of the <tt>CardWithTravelsLimit</tt>
 * class.
 *
 * @author Nickolay Prihodii
 */

public class CardWithTravelsLimit extends Card {

    /**
     * Type of travel card (five passes, ten passes).
     */
    private TravelsLeftCardType travelsLimit;

    /**
     * Remaining passes.
     */
    private int travelsLeft;

    /**
     * Constructs a Card with travels limit.
     *
     * @param id           card ID
     * @param ownerType    type of card owner (Adult, student etc.)
     * @param travelsLimit type of travel card (five passes, ten passes)
     */
    public CardWithTravelsLimit(long id, OwnerCardType ownerType, TravelsLeftCardType travelsLimit) {
        super(id, ownerType);
        this.travelsLimit = travelsLimit;
        this.travelsLeft = travelsLimit.getTravelsLeft();
    }

    /**
     * returns the number of remaining passes.
     */
    public int getTravelsLeft() {
        return travelsLeft;
    }

    /**
     * Returns true if card acceptable and false if not.
     * Card acceptable if remaining passes > 0.
     * If card accept remaining passes is reduced by one.
     */
    @Override
    public boolean accept() {
        if (this.getTravelsLeft() > 0) {
            travelsLeft--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a string representation of the card parameters
     * (id, ownerType, travelsLeft);
     *
     * @return a string representation of the card.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(" TRAVELS_LEFT: ")
                .append(getTravelsLeft());
        return sb.toString();
    }
}
