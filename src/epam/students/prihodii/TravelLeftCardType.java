package epam.students.prihodii;

public enum TravelLeftCardType {

    FIVE(5),
    TEN(10);

    private int tripsLeft;

    private TravelLeftCardType(int tripsLeft) {
        this.tripsLeft = tripsLeft;
    }

    public int getTravelsLeft() {
        return tripsLeft;
    }
}
