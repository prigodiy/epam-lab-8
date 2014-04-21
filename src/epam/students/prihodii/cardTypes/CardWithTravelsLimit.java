package epam.students.prihodii.cardTypes;

import epam.students.prihodii.types.OwnerCardType;
import epam.students.prihodii.types.TravelsLeftCardType;

public class CardWithTravelsLimit extends Card {

    private TravelsLeftCardType travelsLimit;
    private int travelsLeft;

    public CardWithTravelsLimit(long id, OwnerCardType ownerType, TravelsLeftCardType travelsLimit) {
        super(id, ownerType);
        this.travelsLimit = travelsLimit;
        this.travelsLeft = travelsLimit.getTravelsLeft();
    }

    public int getTravelsLeft() {
        return travelsLeft;
    }

    @Override
    public boolean accept() {
        if (this.getTravelsLeft() > 0) {
            travelsLeft--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(" TRAVELS_LEFT: ")
                .append(travelsLeft);
        return sb.toString();
    }
}
