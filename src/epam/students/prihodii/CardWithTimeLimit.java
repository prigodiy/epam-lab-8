package epam.students.prihodii;

import java.util.Date;

public class CardWithTimeLimit extends Card {

    private TimeCardType typeTimeLimit;
    private Date expDate;

    public CardWithTimeLimit(long id, OwnerCardType ownerType, TimeCardType typeTimeLimit) {
        super(id, ownerType);
        this.typeTimeLimit = typeTimeLimit;
        this.expDate = new Date(new Date().getTime() + typeTimeLimit.getDaysLeft() *
                24 * 60 * 60 * 1000L);
    }

    @Override
    public boolean acceptable() {
        return new Date().before(expDate);
    }
}
