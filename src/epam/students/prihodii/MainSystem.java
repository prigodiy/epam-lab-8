package epam.students.prihodii;

import epam.students.prihodii.cardTypes.Card;
import epam.students.prihodii.cardTypes.CardWithMoneyLimit;
import epam.students.prihodii.cardTypes.CardWithTimeLimit;
import epam.students.prihodii.cardTypes.CardWithTravelsLimit;
import epam.students.prihodii.types.OwnerCardType;
import epam.students.prihodii.types.TimeCardType;
import epam.students.prihodii.types.TravelsLeftCardType;

/**
 * This class provides a implementation of the card creation and
 * refilling card system.
 *
 * @author Nickolay Prihodii
 */

public class MainSystem {

    /**
     * Price per one pass.
     */
    private final static int TRAVEL_COST = 5;

    /**
     * instance of MainSystem.
     */
    private static MainSystem instance;

    /**
     * Card ID.
     */
    private static long cardId;

    /**
     * Register which contains records of all passes.
     */
    private static PassRegister passRegister = new PassRegister();

    /**
     * Returns an instance of MainSystem.
     */
    public static MainSystem getInstance() {
        if (instance == null) {
            instance = new MainSystem();
        }
        return instance;
    }

    /**
     * Returns register.
     */
    public PassRegister getPassRegister() {
        return passRegister;
    }

    /**
     * Returns an instance of CardWithTimeLimit class.
     */
    public Card createCard(OwnerCardType ownerType, TimeCardType timeType) {
        if (ownerType == null || timeType == null) {
            return null;
        }
        return new CardWithTimeLimit(cardId++, ownerType, timeType);
    }

    /**
     * Returns an instance of CardWithTravelsLimit class.
     */
    public Card createCard(OwnerCardType ownerType, TravelsLeftCardType travelsLeftCardType) {
        if (ownerType == null || travelsLeftCardType == null) {
            return null;
        }
        return new CardWithTravelsLimit(cardId++, ownerType, travelsLeftCardType);
    }

    /**
     * Returns an instance of CardWithMoneyLimit class.
     */
    public Card createCard(int balance) {
        return new CardWithMoneyLimit(cardId++, TRAVEL_COST, balance);
    }

    /**
     * Add money to card. If money > 0 and card != null money will
     * be added to card and method returns true transaction status.
     * Else returns false.
     *
     * @param  card  instance of CardWithMoneyLimit class
     * @param  money the amount of added money
     *
     * @return status of transaction
     */
    public boolean refillingCard(CardWithMoneyLimit card, int money) {
        if (money <= 0 || card == null) {
            return false;
        } else {
            card.setBalance(card.getBalance() + money);
            return true;
        }
    }
}
