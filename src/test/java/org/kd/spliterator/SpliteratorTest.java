package org.kd.spliterator;

import org.testng.annotations.Test;
import org.kd.Person;

import java.util.Spliterator;

public class SpliteratorTest {

    @Test
    public void tetCall(){
        Spliterator<Person> split1 = SpliteratorExecutor.generateElements().spliterator();
        Spliterator<Person> split2 = split1.trySplit();

        /*assertThat(new Task(split1).call())
                .containsSequence(SpliteratorExecutor.generateElements().size() / 2 + "");
        assertThat(new Task(split2).call())
                .containsSequence(SpliteratorExecutor.generateElements().size() / 2 + "");
    */}
}
