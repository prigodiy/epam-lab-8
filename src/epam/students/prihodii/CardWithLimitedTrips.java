package epam.students.prihodii;

public class CardWithLimitedTrips extends Card {

    private int tripLeft;

    public CardWithLimitedTrips(long id, String type, int tripLeft) {
        super(id, type);
        this.tripLeft = tripLeft;
    }

    public int getTripLeft() {
        return tripLeft;
    }

    public void setTripLeft(int tripLeft) {
        this.tripLeft = tripLeft;
    }
}
