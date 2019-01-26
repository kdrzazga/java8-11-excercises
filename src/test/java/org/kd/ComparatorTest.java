package org.kd;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComparatorTest {

    @Test
    public void testSortingAccordingToWeight(){
        var apples = new Vector<Apple>();
        apples.addAll(new ObjectsFactory().createAppleList());

        apples.sort(
                (Apple a1, Apple a2) ->
                        Integer.valueOf(a1.getWeight()).compareTo(
                                Integer.valueOf(a2.getWeight())));

        assertTrue(apples.get(0).getWeight() < apples.get(apples.size() -1 ).getWeight());
    }
}
