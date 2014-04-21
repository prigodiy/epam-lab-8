package epam.students.prihodii;

import epam.students.prihodii.cardTypes.Card;

import java.util.*;

class PassRegister {

    private List<String> registerHolder = new LinkedList<String>();

    public void addPass(Card card, boolean passStatus) {
        registerHolder.add(card.toString() + " PASS: " + passStatus);
    }

    public List<String> getFullRegister() {
        return registerHolder;
    }

    public List<String> getMoneyCardPassRegister() {
        return getFilteredRegister("BALANCE");
    }

    public List<String> getTravelsLeftCardPassRegister() {
        return getFilteredRegister("TRAVELS_LEFT");
    }

    public List<String> getTimeLeftCardPassRegister() {
        return getFilteredRegister("EXP_DATE");
    }

    private List<String> getFilteredRegister(String filter) {
        if (filter == null || filter == "") {
            return registerHolder;
        }
        List<String> result = new LinkedList<String>();
        for (String record : registerHolder) {
            if (record.contains(filter)) {
                result.add(record);
            }
        }
        return result;
    }
}
