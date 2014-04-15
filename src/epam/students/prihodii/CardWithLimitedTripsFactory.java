package epam.students.prihodii;

public class CardWithLimitedTripsFactory {

    public static CardWithLimitedTrips createCard(CardOwnerType cardOwnerType) {
        switch (cardOwnerType) {
            case SCHOOL_FIVE_TRIPS:
                return new CardWithLimitedTrips(0, "SCHOOL", 5);
            case SCHOOL_TEN_TRIPS:
                return new CardWithLimitedTrips(0, "SCHOOL", 10);
            case STUDENT_FIVE_TRIPS:
                return new CardWithLimitedTrips(0, "STUDENT", 5);
            case STUDENT_TEN_TRIPS:
                return new CardWithLimitedTrips(0, "STUDENT", 10);
            case ADULT_FIVE_TRIPS:
                return new CardWithLimitedTrips(0, "ADULT", 5);
            case ADULT_TEN_TRIPS:
                return new CardWithLimitedTrips(0, "ADULT", 10);
            default:
                return null;
        }
    }
}
