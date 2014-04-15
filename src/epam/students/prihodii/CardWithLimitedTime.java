package epam.students.prihodii;

import java.util.Date;

public class CardWithLimitedTime extends Card {

    private Date expDate;

    public CardWithLimitedTime(long id, String type, Date expDate) {
        super(id, type);
        this.expDate = expDate;
    }

    public Date getExpDate() {
        return expDate;
    }
}
