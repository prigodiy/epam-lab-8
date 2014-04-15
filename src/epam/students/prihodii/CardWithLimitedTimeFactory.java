package epam.students.prihodii;

import java.util.Date;

public class CardWithLimitedTimeFactory {

    private static Date getExpDate(long days) {
        return new Date(new Date().getTime() + days * 24 * 60 * 60 * 1000);
    }

    public static CardWithLimitedTime createCard(CardType cardType) {
        switch (cardType) {
            case SCHOOL_TEN_DAYS:
                return new CardWithLimitedTime(0, "SCHOOL", getExpDate(10));
            case SCHOOL_MONTH:
                return new CardWithLimitedTime(0, "SCHOOL", getExpDate(30));
            case STUDENT_TEN_DAYS:
                return new CardWithLimitedTime(0, "STUDENT", getExpDate(10));
            case STUDENT_MONTH:
                return new CardWithLimitedTime(0, "STUDENT", getExpDate(30));
            case ADULT_TEN_DAYS:
                return new CardWithLimitedTime(0, "ADULT", getExpDate(10));
            case ADULT_MONTH:
                return new CardWithLimitedTime(0, "ADULT", getExpDate(30));
            default:
                return null;
        }
    }
}
