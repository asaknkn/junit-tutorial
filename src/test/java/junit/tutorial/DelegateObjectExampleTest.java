package junit.tutorial;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;

public class DelegateObjectExampleTest {

    @Test
    public void doSomthingを実行するとdateに現在時刻が設定される() {

        final Date current = new Date();
        DelegateObjectExample sut = new DelegateObjectExample();
        sut.dateFactory = new DateFactory() {
            @Override
            public Date newDate() {
                return current;
            }
        };
        sut.doSomthing();
        assertThat(sut.date, is(sameInstance(current)));

    }
}