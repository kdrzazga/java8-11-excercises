package org.kd.spliterator;

import org.junit.jupiter.api.Test;
import org.kd.Person;

import java.util.Spliterator;
import java.util.concurrent.Executor;

import static org.hamcrest.MatcherAssert.assertThat;

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
