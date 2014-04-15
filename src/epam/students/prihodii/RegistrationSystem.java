package epam.students.prihodii;

import java.util.Date;
import java.util.TreeMap;

public class RegistrationSystem {

    private static RegistrationSystem instance;
    private static long id;
    private static TreeMap<Date, String> createdCards = new TreeMap<Date, String>();

    public static RegistrationSystem getInstance() {
        if (instance == null) {
            instance = new RegistrationSystem();
        }
        return instance;
    }

    @Override
    public String toString() {
        return super.toString();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
