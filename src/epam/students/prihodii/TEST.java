package epam.students.prihodii;

import epam.students.prihodii.cardTypes.Card;
import epam.students.prihodii.types.OwnerCardType;
import epam.students.prihodii.types.TimeCardType;

public class TEST {
    public static void main(String[] args) {
        MainSystem ms = MainSystem.getInstance();
        Turnstile ts = new Turnstile(ms);
        Card myCard = ms.createCard(OwnerCardType.STUDENT, TimeCardType.MONTH);
        Card money = ms.createCard(OwnerCardType.STUDENT, 5);
        ts.acceptCard(myCard);
        ts.acceptCard(money);
        System.out.println(ms.getPassRegister().getFullRegister());
        System.out.println(ms.getPassRegister().getMoneyCardPassRegister());
        System.out.println(ms.getPassRegister().getTimeLeftCardPassRegister());
        System.out.println(ms.getPassRegister().getTravelsLeftCardPassRegister());
    }
}
