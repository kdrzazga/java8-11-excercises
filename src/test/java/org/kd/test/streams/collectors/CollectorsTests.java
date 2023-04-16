package org.kd.test.streams.collectors;

import org.testng.annotations.Test;
import org.kd.ObjectsFactory;
import org.kd.Person;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CollectorsTests {

    private final PrintStream output = System.out;

    @Test
    public void testNames() {
        var actualNames = new ObjectsFactory().createPolishRulers().stream().map(Person::getName).collect(Collectors.toList());
        var expectedNames = List.of(
                "Leszko", "Popiel", "Popiel", "Piast Kolodziej",
                "Siemowit", "Lestek", "Siemomysl", "Mieszko");

        assertTrue(actualNames.containsAll(expectedNames));
        assertTrue(expectedNames.containsAll(actualNames));

    }

    @Test
    public void testJoining() {
        assertEquals("Leszko, Popiel, Popiel, Piast Kolodziej, "
                        + "Siemowit, Lestek, Siemomysl, Mieszko",

                new ObjectsFactory().createPolishRulers().stream()
                        .map(Person::getName)
                        .collect(Collectors.joining(", ")));

    }

    @Test
    public void testAveraging() {
        var averageAge = new ObjectsFactory().createPolishRulers().stream().collect(Collectors.averagingInt(Person::getAge));
        assertTrue((averageAge > 750) && (averageAge < 966));
    }

    @Test
    public void testPopiels() {

        assertThat(List.of(
                new Person("Popiel", 775),
                new Person("Popiel", 800)
                ),
                is(new ArrayList<>(new ObjectsFactory().createPolishRulers().stream()
                        .collect(Collectors.groupingBy(Person::getName))
                        .get("Popiel"))));
    }
}
