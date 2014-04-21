package epam.students.prihodii.cardTypes;

import epam.students.prihodii.types.OwnerCardType;
import epam.students.prihodii.types.TimeCardType;

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

    public Date getExpDate() {
        return expDate;
    }

    @Override
    public boolean accept() {
        return new Date().before(this.getExpDate());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(" EXP_DATE: ")
                .append(expDate);
        return sb.toString();
    }
}
