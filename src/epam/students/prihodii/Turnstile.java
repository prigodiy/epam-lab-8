package epam.students.prihodii;

import java.util.Date;
import java.util.TreeMap;

public class Turnstile {

    private int travelCost = 5;
    private TreeMap<Date, String> turnstileLog = new TreeMap<Date, String>();

    public void setTravelCost(int travelCost) {
        this.travelCost = travelCost;
    }

    public int getTravelCost() {
        return travelCost;
    }

    public TreeMap<Date, String> getTurnstileLog() {
        return turnstileLog;
    }

    public boolean acceptCard() {
        return false;
    }
}
