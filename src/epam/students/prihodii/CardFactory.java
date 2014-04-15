package epam.students.prihodii;

public class CardFactory {

    public static Card createCard(CardOwnerType cardOwnerType) {
        switch (cardOwnerType) {
            case SCHOOL_TEN_DAYS:
                return CardWithLimitedTimeFactory.createCard(CardOwnerType.SCHOOL_TEN_DAYS);
            case SCHOOL_MONTH:
                return CardWithLimitedTimeFactory.createCard(CardOwnerType.SCHOOL_MONTH);
            case STUDENT_TEN_DAYS:
                return CardWithLimitedTimeFactory.createCard(CardOwnerType.STUDENT_TEN_DAYS);
            case STUDENT_MONTH:
                return CardWithLimitedTimeFactory.createCard(CardOwnerType.STUDENT_MONTH);
            case ADULT_TEN_DAYS:
                return CardWithLimitedTimeFactory.createCard(CardOwnerType.ADULT_TEN_DAYS);
            case ADULT_MONTH:
                return CardWithLimitedTimeFactory.createCard(CardOwnerType.ADULT_MONTH);
            case SCHOOL_FIVE_TRIPS:
                return CardWithLimitedTripsFactory.createCard(CardOwnerType.SCHOOL_FIVE_TRIPS);
            case SCHOOL_TEN_TRIPS:
                return CardWithLimitedTripsFactory.createCard(CardOwnerType.SCHOOL_TEN_TRIPS);
            case STUDENT_FIVE_TRIPS:
                return CardWithLimitedTripsFactory.createCard(CardOwnerType.SCHOOL_FIVE_TRIPS);
            case STUDENT_TEN_TRIPS:
                return CardWithLimitedTripsFactory.createCard(CardOwnerType.STUDENT_TEN_TRIPS);
            case ADULT_FIVE_TRIPS:
                return CardWithLimitedTripsFactory.createCard(CardOwnerType.ADULT_FIVE_TRIPS);
            case ADULT_TEN_TRIPS:
                return CardWithLimitedTripsFactory.createCard(CardOwnerType.ADULT_TEN_TRIPS);
            case ADULT_MONEY_CARD:
                return CardWithLimitedMoneyFactory.createCard(CardOwnerType.ADULT_MONEY_CARD);
            default:
                return null;
        }
    }
}
