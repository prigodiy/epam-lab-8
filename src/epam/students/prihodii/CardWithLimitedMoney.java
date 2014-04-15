package epam.students.prihodii;

public class CardWithLimitedMoney extends Card {

    private int money;

    public CardWithLimitedMoney(long id, int money) {
        super(id, "ADULT");
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
