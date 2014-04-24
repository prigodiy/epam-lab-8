package epam.students.prihodii;

import epam.students.prihodii.cardTypes.Card;

/**
 * This class provides a implementation of the Turnstile
 * which can accept card.
 *
 * @author Nickolay Prihodii
 */

public class Turnstile {

    /**
     * Connected mainSystem.
     */
    private MainSystem mainSystem;

    /**
     * Constructs a turnstile.
     *
     * @param  mainSystem  connected system
     */
    public Turnstile(MainSystem mainSystem) {
        this.mainSystem = mainSystem;
    }

    /**
     * Returns pass status. Try if card accepted, false if card
     * invalid. And add record about pass to main system register.
     *
     * @param  card  card for accept
     * @return pass status
     */
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
