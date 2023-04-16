package org.kd;

import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertTrue;

public class ComparatorTest {

    @Test
    public void testSortingAccordingToWeight(){
        var apples = new Vector<>(new ObjectsFactory().createAppleList());

        apples.sort(
                (Apple a1, Apple a2) ->
                        Integer.valueOf(a1.getWeight()).compareTo(
                                a2.getWeight()));

        assertTrue(apples.get(0).getWeight() < apples.get(apples.size() -1 ).getWeight());
    }
}
