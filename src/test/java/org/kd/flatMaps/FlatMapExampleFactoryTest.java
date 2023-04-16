package org.kd.flatMaps;

import org.kd.ObjectsFactory;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;

public class FlatMapExampleFactoryTest {

    @Test
    public void testFlatMaps() {
        assertThat(new ObjectsFactory().createListOfLists()
                        .stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList())

                , is(List.of("a", "b", "c")));
    }

    @Test
    public void testNoMapping() {
        assertThat(new ObjectsFactory().createListOfLists(),

                is(Arrays.asList(
                        Collections.singletonList("a"),
                        Arrays.asList("b", "c"))));
    }

    @Test
    public void testMap() {
        assertThat(new ObjectsFactory().createListOfLists()
                        .stream()
                        .map(Collection::stream)
                        .collect(Collectors.toList()),

                not(is(Arrays.asList(
                        Stream.of("a"),
                        Stream.of("b", "c")))));//references are different
    }

    @Test
    public void testDoubleFlatting() {
        assertThat(
                new ObjectsFactory().createListOfListOfLists()
                        .stream()
                        .flatMap(Collection::stream)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList()),

                is(List.of("a", "b", "c")));
    }
}
