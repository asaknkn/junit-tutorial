package junit.tutorial;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

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
        //モックの設定
        final AtomicBoolean isCallNextIntMethod = new AtomicBoolean(false);
        //スタブ実装(匿名クラス使用)
        sut.generator = new RandomNumberGenerator() {
            @Override
            public int nextInt() {
                isCallNextIntMethod.set(true);
                return 1;
            }
        };
        assertThat(sut.choice(options), is("B"));
        assertThat(isCallNextIntMethod.get(), is(true));
    }

    @Test
    public void choiceでCを返す() throws Exception {
        List<String> options = new ArrayList<String>();
        options.add("A");
        options.add("B");
        options.add("C");
        Randoms sut = new Randoms();
        //スタブ実装(ラムダの使用)
        sut.generator = () -> {return 2;};
        assertThat(sut.choice(options), is("C"));
    }

}