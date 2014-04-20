package epam.students.prihodii.types;

public enum TravelsLeftCardType {

    FIVE(5),
    TEN(10);

    private int tripsLeft;

    private TravelsLeftCardType(int tripsLeft) {
        this.tripsLeft = tripsLeft;
    }

    public int getTravelsLeft() {
        return tripsLeft;
    }
}
