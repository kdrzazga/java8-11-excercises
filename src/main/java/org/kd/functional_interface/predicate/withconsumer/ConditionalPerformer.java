package org.kd.functional_interface.predicate.withconsumer;

import org.kd.Person;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConditionalPerformer {

    public void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer){
        for (Person person : people){
            if (predicate.test(person))
                consumer.accept(person);
        }
    }

}
