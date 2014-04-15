package epam.students.prihodii;

import java.util.Date;
import java.util.TreeMap;

public class Turnstile {

    private int travelCost = 5;
    private TreeMap<Date, String> turnstileLog = new TreeMap<Date, String>();

    public void setTravelCost(int travelCost) {
        this.travelCost = travelCost;
    }

    public int getTravelCost() {
        return travelCost;
    }

    public TreeMap<Date, String> getTurnstileLog() {
        return turnstileLog;
    }

    public boolean acceptCard(Card card) {


        if (card.getClass() == CardWithLimitedMoney.class) {
            int cardBalance = ((CardWithLimitedMoney) card).getMoney();
            if (cardBalance >= travelCost) {
                ((CardWithLimitedMoney) card).setMoney(cardBalance - travelCost);
                turnstileLog.put(new Date(), "CARD_ID: " + card.getId() +
                        " CARD_TYPE: " + card.getType() + " CARD_MONEY_BALANCE: " +
                        cardBalance + " PASS_ALLOWED: YES");
                return true;
            } else {
                turnstileLog.put(new Date(), "CARD_ID: " + card.getId() +
                        " CARD_TYPE: " + card.getType() + " CARD_MONEY_BALANCE: " +
                        cardBalance + " PASS_ALLOWED: NO");
                return false;
            }
        }

        if (card.getClass() == CardWithLimitedTime.class) {
            Date cardExpDate = ((CardWithLimitedTime) card).getExpDate();
            if (cardExpDate.after(new Date())) {
                turnstileLog.put(new Date(), "CARD_ID: " + card.getId() +
                        " CARD_TYPE: " + card.getType() + " CARD_EXPIRATION_DATE: " +
                        cardExpDate + " PASS_ALLOWED: YES");
                return true;
            } else {
                turnstileLog.put(new Date(), "CARD_ID: " + card.getId() +
                        " CARD_TYPE: " + card.getType() + " CARD_EXPIRATION_DATE: " +
                        cardExpDate + " PASS_ALLOWED: NO");
                return false;
            }
        }

        if (card.getClass() == CardWithLimitedTrips.class) {
            int cardTripsLeft = ((CardWithLimitedTrips) card).getTripLeft();
            if (cardTripsLeft > 0) {
                ((CardWithLimitedTrips) card).setTripLeft(cardTripsLeft - 1);
                turnstileLog.put(new Date(), "CARD_ID: " + card.getId() +
                        " CARD_TYPE: " + card.getType() + " CARD_TRIPS_LEFT: " +
                        cardTripsLeft + " PASS_ALLOWED: YES");
                return true;
            } else {
                turnstileLog.put(new Date(), "CARD_ID: " + card.getId() +
                        " CARD_TYPE: " + card.getType() + " CARD_TRIPS_LEFT: " +
                        cardTripsLeft + " PASS_ALLOWED: NO");
                return false;
            }
        }

        turnstileLog.put(new Date(), "UNKNOWN_CARD PASS_ALLOWED: NO");
        return false;
    }
}
