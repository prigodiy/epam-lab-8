package epam.students.prihodii.cardTypes;

import epam.students.prihodii.types.OwnerCardType;

public abstract class Card {

    private long id;
    private OwnerCardType ownerType;

    public Card(long id, OwnerCardType ownerType) {
        this.id = id;
        this.ownerType = ownerType;
    }

    public long getId() {
        return id;
    }

    public OwnerCardType getOwnerType() {
        return ownerType;
    }

    public abstract boolean accept();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CARD_ID: ")
                .append(getId())
                .append(" CARD_OWNER: ")
                .append(getOwnerType().name());
        return sb.toString();
    }
}