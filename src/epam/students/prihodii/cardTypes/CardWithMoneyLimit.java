package epam.students.prihodii.cardTypes;

import epam.students.prihodii.types.OwnerCardType;

/**
 * This class provides a implementation of the <tt>CardWithMoneyLimit</tt>
 * class.
 *
 * @author Nickolay Prihodii
 */

public class CardWithMoneyLimit extends Card {

    /**
     * Money balance on card.
     */
    private int balance;

    /**
     * Cost per one pass.
     */
    private int travelCost;

    /**
     * Constructs a Card with money limit.
     *
     * @param id         card ID
     * @param travelCost cost per one pass
     * @param balance    money balance on card
     */
    public CardWithMoneyLimit(long id, int travelCost, int balance) {
        super(id, OwnerCardType.ADULT);
        this.travelCost = travelCost;
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    /**
     * Returns money balance.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Set money balance.
     *
     * @param balance add money to the card
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * Returns true if card acceptable and false if not.
     * Card acceptable if balance >= cost per pass.
     * If card accept balance is reduced by the price of pass.
     */
    @Override
    public boolean accept() {
        if (balance >= travelCost) {
            balance -= travelCost;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a string representation of the card parameters
     * (id, ownerType, balance);
     *
     * @return a string representation of the card.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(" BALANCE: ")
                .append(getBalance());
        return sb.toString();
    }
}
