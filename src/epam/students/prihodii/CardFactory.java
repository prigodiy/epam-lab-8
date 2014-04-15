package epam.students.prihodii;

public class CardFactory {

    public static Card createCard(CardType cardType) {
        switch (cardType) {
            case SCHOOL_TEN_DAYS:
                return CardWithLimitedTimeFactory.createCard(CardType.SCHOOL_TEN_DAYS);
            case SCHOOL_MONTH:
                return CardWithLimitedTimeFactory.createCard(CardType.SCHOOL_MONTH);
            case STUDENT_TEN_DAYS:
                return CardWithLimitedTimeFactory.createCard(CardType.STUDENT_TEN_DAYS);
            case STUDENT_MONTH:
                return CardWithLimitedTimeFactory.createCard(CardType.STUDENT_MONTH);
            case ADULT_TEN_DAYS:
                return CardWithLimitedTimeFactory.createCard(CardType.ADULT_TEN_DAYS);
            case ADULT_MONTH:
                return CardWithLimitedTimeFactory.createCard(CardType.ADULT_MONTH);
            case SCHOOL_FIVE_TRIPS:
                return CardWithLimitedTripsFactory.createCard(CardType.SCHOOL_FIVE_TRIPS);
            case SCHOOL_TEN_TRIPS:
                return CardWithLimitedTripsFactory.createCard(CardType.SCHOOL_TEN_TRIPS);
            case STUDENT_FIVE_TRIPS:
                return CardWithLimitedTripsFactory.createCard(CardType.SCHOOL_FIVE_TRIPS);
            case STUDENT_TEN_TRIPS:
                return CardWithLimitedTripsFactory.createCard(CardType.STUDENT_TEN_TRIPS);
            case ADULT_FIVE_TRIPS:
                return CardWithLimitedTripsFactory.createCard(CardType.ADULT_FIVE_TRIPS);
            case ADULT_TEN_TRIPS:
                return CardWithLimitedTripsFactory.createCard(CardType.ADULT_TEN_TRIPS);
            case ADULT_MONEY_CARD:
                return CardWithLimitedMoneyFactory.createCard(CardType.ADULT_MONEY_CARD);
            default:
                return null;
        }
    }
}
