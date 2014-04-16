package epam.students.prihodii;

public class CardWithTravelLimit extends Card {

    private TravelLeftCardType travelLimit;

    public CardWithTravelLimit(long id, OwnerCardType ownerType, TravelLeftCardType travelLimit) {
        super(id, ownerType);
        this.travelLimit = travelLimit;
    }
}
