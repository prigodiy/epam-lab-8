package epam.students.prihodii.cardTypes;

import epam.students.prihodii.types.OwnerCardType;
import epam.students.prihodii.types.TimeCardType;

import java.util.Date;

/**
 * This class provides a implementation of the <tt>CardWithTimeLimit</tt>
 * class.
 *
 * @author Nickolay Prihodii
 */

public class CardWithTimeLimit extends Card {

    /**
     * Type of time card (ten days, month).
     */
    private TimeCardType typeTimeLimit;

    /**
     * Expiration date.
     */
    private Date expDate;

    /**
     * Constructs a Card with time limit.
     *
     * @param id            card ID
     * @param ownerType     type of card owner (Adult, student etc.)
     * @param typeTimeLimit type of time card (ten days, month)
     */
    public CardWithTimeLimit(long id, OwnerCardType ownerType, TimeCardType typeTimeLimit) {
        super(id, ownerType);
        this.typeTimeLimit = typeTimeLimit;
        this.expDate = new Date(new Date().getTime() + typeTimeLimit.getDaysLeft() *
                24 * 60 * 60 * 1000L);
    }

    /**
     * Returns card expiration date.
     */
    public Date getExpDate() {
        return expDate;
    }

    /**
     * Returns true if card acceptable and false if not.
     * Card acceptable if pass date before expiration date.
     */
    @Override
    public boolean accept() {
        return new Date().before(this.getExpDate());
    }

    /**
     * Returns a string representation of the card parameters
     * (id, ownerType, expDate);
     *
     * @return a string representation of the card.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(" EXP_DATE: ")
                .append(getExpDate());
        return sb.toString();
    }
}
