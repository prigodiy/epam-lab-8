package epam.students.prihodii;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class TEST {
    public static void main(String[] args) throws InterruptedException {
        RegistrationSystem registrationSystem = RegistrationSystem.getInstance();
        Card card = registrationSystem.createCard(CardType.ADULT_FIVE_TRIPS);
        Turnstile turnstile = new Turnstile();
        turnstile.acceptCard(card);
        Thread.sleep(100);
        turnstile.acceptCard(card);
        Thread.sleep(100);
        turnstile.acceptCard(card);
        Thread.sleep(100);
        turnstile.acceptCard(card);
        Thread.sleep(100);
        turnstile.acceptCard(card);
        Thread.sleep(100);
        turnstile.acceptCard(card);
        Thread.sleep(100);
        turnstile.acceptCard(card);
        Thread.sleep(100);
        turnstile.acceptCard(card);
        Thread.sleep(100);
        TreeMap<Date, String> treeMap = turnstile.getTurnstileLog();
        for (Map.Entry<Date, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
