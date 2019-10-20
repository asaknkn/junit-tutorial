package junit.tutorial;

import java.util.Date;

public class DelegateObjectExample {

    DateFactory dateFactory = new DateFactory();
    Date date = new Date();

    public void doSomthing() {
        this.date = dateFactory.newDate();
    }
}
