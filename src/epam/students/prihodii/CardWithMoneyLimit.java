package epam.students.prihodii;

public class CardWithMoneyLimit extends Card {

    private int balance;

    public CardWithMoneyLimit(long id, OwnerCardType ownerType, int balance) {
        super(id, OwnerCardType.ADULT);
        this.balance = balance;
    }
}
