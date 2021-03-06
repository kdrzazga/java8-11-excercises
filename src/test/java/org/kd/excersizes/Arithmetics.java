package org.kd.excersizes;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Arithmetics {

    @Test
    public void sumOfEvenNumbers0to5() {
        assertEquals(0 + 2 + 4, IntStream
                .range(0, 6)
                .filter(i -> i % 2 == 0)
                .sum());
    }

    @Test
    public void averageOfOddNumbers0to10() {
        assertEquals((1 + 3 + 5 + 7 + 9) / 5.0, IntStream
                .range(0, 10)
                .filter(n -> n % 2 == 1)
                .average()
                .getAsDouble());
    }

}
