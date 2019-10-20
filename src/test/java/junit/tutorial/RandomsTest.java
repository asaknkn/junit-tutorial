package junit.tutorial;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RandomsTest {

    @Test
    public void choiceでAを返す() throws Exception {
        List<String> options = new ArrayList<String>();
        options.add("A");
        options.add("B");
        Randoms sut = new Randoms();
        //スタブ利用
        sut.generator = new RandomNumberGeneratorFixedResultStub();
        assertThat(sut.choice(options), is("A"));
    }

    @Test
    public void choiceでBを返す() throws Exception {
        List<String> options = new ArrayList<String>();
        options.add("A");
        options.add("B");
        Randoms sut = new Randoms();
        //スタブ実装
        sut.generator = new RandomNumberGenerator() {
            @Override
            public int nextInt() {
                return 1;
            }
        };
        assertThat(sut.choice(options), is("B"));
    }

}