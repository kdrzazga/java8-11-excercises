package org.kd.streams;

import org.junit.jupiter.api.Test;
import org.kd.ObjectsFactory;
import org.kd.Person;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReduceTests {

    @Test
    public void testReduce() {
        // The lambda expression passed to
        // reduce() method takes two Strings
        // and returns the the longer String.
        // The result of the reduce() method is
        // an Optional because the list on which
        // reduce() is called may be empty.

        assertEquals("Piast Kolodziej",

                Optional.ofNullable(
                        new ObjectsFactory().createPolishRulers()
                        //new ArrayList<Person>()
                                .stream()
                                .map(Person::getName)
                                .reduce((word1, word2)
                                        -> word1.length() > word2.length()
                                        ? word1 : word2))
                        .get()
                        .orElse(""));
    }
}
