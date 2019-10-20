package junit.tutorial;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;

public class MethodExtractExampleTest {

    @Test
    public void doSomethingを実行するとdateに現在時刻が設定される() throws Exception {
        final Date current = new Date();
        MethodExtractExample sut = new MethodExtractExample(){
            @Override
            Date newDate() {
                return current;
            }
        };
        sut.doSomething();
        assertThat(sut.date, is(sameInstance(current)));
    }
}