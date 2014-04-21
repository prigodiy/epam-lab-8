package epam.students.prihodii;

import epam.students.prihodii.cardTypes.Card;
import epam.students.prihodii.cardTypes.CardWithMoneyLimit;
import epam.students.prihodii.cardTypes.CardWithTimeLimit;
import epam.students.prihodii.cardTypes.CardWithTravelsLimit;
import epam.students.prihodii.types.OwnerCardType;
import epam.students.prihodii.types.TimeCardType;
import epam.students.prihodii.types.TravelsLeftCardType;

import java.util.TreeMap;

public class MainSystem {

    private final static int TRAVEL_COST = 5;
    private static MainSystem instance;
    private static long cardId;

    private static PassRegister passRegister = new PassRegister();

    public static MainSystem getInstance() {
        if (instance == null) {
            instance = new MainSystem();
        }
        return instance;
    }

    public PassRegister getPassRegister() {
        return passRegister;
    }

    public Card createCard(OwnerCardType ownerType, TimeCardType timeType) {
        if (ownerType == null || timeType == null) {
            return null;
        }
        return new CardWithTimeLimit(cardId++, ownerType, timeType);
    }

    public Card createCard(OwnerCardType ownerType, TravelsLeftCardType travelsLeftCardType) {
        if (ownerType == null || travelsLeftCardType == null) {
            return null;
        }
        return new CardWithTravelsLimit(cardId++, ownerType, travelsLeftCardType);
    }

    public Card createCard(int balance) {
        return new CardWithMoneyLimit(cardId++, TRAVEL_COST, balance);
    }

    public boolean refillingCard(CardWithMoneyLimit card, int money) {
        if (money <= 0 || card == null) {
            return false;
        } else {
            card.setBalance(card.getBalance() + money);
            return true;
        }
    }
}
