package org.kd.test.streams.collectors;

import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class MappingToSquareValue {

    /*Mapping is not only for accessing methods*/
    @Test
    public void testMappingToSquares() {
        assertThat(
                List.of(1, 4, 9, 16)

                , is(IntStream.range(1, 5)//5 is avoided in IntStream
                        .map(n -> n * n)
                        .boxed()
                        .collect(Collectors.toList())));
    }

    @Test
    public void testStreamsEquivalence() {
        assertThat(
                Stream.of(1, 2, 3, 4)
                , not(is(IntStream.range(1, 5).boxed()//5 is avioded in IntStream
                )));
    }
}
