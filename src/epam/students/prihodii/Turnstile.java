package epam.students.prihodii;

public class Turnstile {

    private RegistrationSystem registrationSystem;

    public boolean acceptCard(Card card) {
        if(card == null) {
            return false;
        }
        return card.acceptable();
    }
}
