package junit.tutorial;

import java.util.Date;

public class MethodExtractExample {
    Date date = newDate();

    public void doSomething(){
        this.date = newDate();
    }

    Date newDate() {
        return new Date();
    }
}
