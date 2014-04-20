package epam.students.prihodii.types;

public enum TimeCardType {

    TEN_DAYS(10),
    MONTH(30);

    private int daysLeft;

    private TimeCardType(int daysLeft) {
        this.daysLeft = daysLeft;
    }

    public int getDaysLeft() {
        return daysLeft;
    }
}
