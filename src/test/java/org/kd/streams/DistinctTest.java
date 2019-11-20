package org.kd.streams;

import org.junit.jupiter.api.Test;
import org.kd.ObjectsFactory;
import org.kd.Person;

import java.util.Vector;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistinctTest {

    @Test
    public void testDistinct() {
        assertEquals(1,
                new ObjectsFactory().createPolishRulers().stream()
                        .map(Person::getName)
                        .distinct()
                        .filter(name -> name.equalsIgnoreCase("popiel"))
                        .count());
    }

    @Test
    public void testHowManyLettersOfAlphabetOccursInWord() {
        var wordWith14LettersOfAlphabet = "pneumonoultramicroscopicsilicovolcanoconiosis";
        var letters = new Vector<>(wordWith14LettersOfAlphabet.length());
        IntStream.range(0, wordWith14LettersOfAlphabet.length()).forEach(index -> letters.add(wordWith14LettersOfAlphabet.charAt(index)));

        assertEquals(14, letters.stream().distinct().count());
    }
}
