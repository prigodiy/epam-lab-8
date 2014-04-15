package epam.students.prihodii;

import java.util.Date;
import java.util.TreeMap;

public class RegistrationSystem {

    private static RegistrationSystem instance;
    private static long id;
    private static TreeMap<Date, String> createdCards = new TreeMap<Date, String>();

    public static RegistrationSystem getInstance() {
        if (instance == null) {
            instance = new RegistrationSystem();
        }
        return instance;
    }

    public static Card createCard(CardOwnerType cardOwnerType) {
        if (cardOwnerType == null) {
            return null;
        }
        Card newCard = CardFactory.createCard(cardOwnerType);
        newCard.setId(id++);
        createdCards.put(new Date(), "CARD_ID: " + newCard.getId() + " CARD_TYPE: " + cardOwnerType.name());
        return newCard;
    }

    public static boolean cardRefilling(Card card, int money) {
        if((card == null) || !(card.getClass() == CardWithLimitedMoney.class)
                || (money <= 0)) {
            return false;
        } else {
            ((CardWithLimitedMoney) card).setMoney(((CardWithLimitedMoney) card).getMoney() + money);
            return true;
        }
    }
}
