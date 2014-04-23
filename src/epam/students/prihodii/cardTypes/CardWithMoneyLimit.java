package epam.students.prihodii.cardTypes;

import epam.students.prihodii.types.OwnerCardType;

public class CardWithMoneyLimit extends Card {

    private int balance;
    private int travelCost;

    public CardWithMoneyLimit(long id, int travelCost, int balance) {
        super(id, OwnerCardType.ADULT);
        this.travelCost = travelCost;
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean accept() {
        if (balance >= travelCost) {
            balance -= travelCost;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(" BALANCE: ")
                .append(getBalance());
        return sb.toString();
    }
}
