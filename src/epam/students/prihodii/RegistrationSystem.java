package epam.students.prihodii;

public class RegistrationSystem {

    private long id;

    public Card createCard(OwnerCardType ownerType, TimeCardType timeType) {
        return new CardWithTimeLimit(id++, ownerType, timeType);
    }

    public Card createCard(OwnerCardType ownerType, TravelLeftCardType travelLeftCardType) {
        return new CardWithTravelLimit(id++, ownerType, travelLeftCardType);
    }

    public Card createCard(OwnerCardType ownerType, int balance) {
        return new CardWithMoneyLimit(id++, ownerType, balance);
    }
}
