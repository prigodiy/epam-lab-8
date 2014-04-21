package epam.students.prihodii;

import epam.students.prihodii.cardTypes.Card;

public class Turnstile {

    private MainSystem mainSystem;

    public Turnstile(MainSystem mainSystem) {
        this.mainSystem = mainSystem;
    }

    public boolean acceptCard(Card card) {
        if (card == null) {
            return false;
        } else {
            boolean result = card.accept();
            mainSystem.getPassRegister().addPass(card, result);
            return result;
        }
    }
}
