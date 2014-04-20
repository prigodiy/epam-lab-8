package epam.students.prihodii;

public class CardWithTravelLimit extends Card {

    private TravelLeftCardType travelsLimit;
    private int travelsLeft;

    public CardWithTravelLimit(long id, OwnerCardType ownerType, TravelLeftCardType travelsLimit) {
        super(id, ownerType);
        this.travelsLimit = travelsLimit;
        this.travelsLeft = travelsLimit.getTravelsLeft();
    }

    @Override
    public boolean acceptable() {
        return (travelsLeft > 0);
    }
}
