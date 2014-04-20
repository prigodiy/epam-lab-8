package epam.students.prihodii;

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

    public void setId(long id) {
        this.id = id;
    }

    public OwnerCardType getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(OwnerCardType ownerType) {
        this.ownerType = ownerType;
    }

    public abstract boolean acceptable();
}