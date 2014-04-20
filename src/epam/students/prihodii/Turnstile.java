package epam.students.prihodii;

import epam.students.prihodii.cardTypes.Card;

public class Turnstile {

    private MainSystem mainSystem;

    public Turnstile(MainSystem mainSystem) {
        this.mainSystem = mainSystem;
    }

    public boolean acceptCard(Card card) {
        boolean result = (card == null) ? false : card.accept();
        if (card != null) {
            mainSystem.getPassRegister().addPass(card, result);
        }
        return result;
    }
}
