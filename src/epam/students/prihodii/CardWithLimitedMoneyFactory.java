package epam.students.prihodii;

public class CardWithLimitedMoneyFactory {

    public static CardWithLimitedMoney createCard(CardType cardType) {
        switch (cardType) {
            case ADULT_MONEY_CARD:
                return new CardWithLimitedMoney(0, 0);
            default:
                return null;
        }
    }
}
