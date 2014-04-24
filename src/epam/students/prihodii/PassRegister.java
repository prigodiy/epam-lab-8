package epam.students.prihodii;

import epam.students.prihodii.cardTypes.Card;

import java.util.LinkedList;
import java.util.List;

/**
 * This class provides a implementation of the Pass register
 * which contains records of passes.
 *
 * @author Nickolay Prihodii
 */

class PassRegister {

    /**
     * Holder of all passes.
     */
    private List<String> registerHolder = new LinkedList<String>();

    /**
     * Add information about pass to register.
     *
     * @param  card  card used for the passage
     * @param  passStatus  pass status
     */
    public void addPass(Card card, boolean passStatus) {
        registerHolder.add(card.toString() + " PASS: " + passStatus);
    }

    /**
     * Returns full register as List.
     */
    public List<String> getFullRegister() {
        return registerHolder;
    }

    /**
     * Returns money card register as List.
     */
    public List<String> getMoneyCardPassRegister() {
        return getFilteredRegister("BALANCE");
    }

    /**
     * Returns travel card register as List.
     */
    public List<String> getTravelsLeftCardPassRegister() {
        return getFilteredRegister("TRAVELS_LEFT");
    }

    /**
     * Returns time card register as List.
     */
    public List<String> getTimeLeftCardPassRegister() {
        return getFilteredRegister("EXP_DATE");
    }

    /**
     * Returns filtered register
     *
     * @param  filter  key string
     * @return List of Strings records which contains key
     */
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
