package epam.students.prihodii;

public class CardWithLimitedMoneyFactory {

    public static CardWithLimitedMoney createCard(CardOwnerType cardOwnerType) {
        switch (cardOwnerType) {
            case ADULT_MONEY_CARD:
                return new CardWithLimitedMoney(0, 0);
            default:
                return null;
        }
    }
}
