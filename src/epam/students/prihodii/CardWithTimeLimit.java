package epam.students.prihodii;

public class CardWithTimeLimit extends Card {

    private TimeCardType typeTimeLimit;

    public CardWithTimeLimit(long id, OwnerCardType ownerType, TimeCardType typeTimeLimit) {
        super(id, ownerType);
        this.typeTimeLimit = typeTimeLimit;
    }
}
