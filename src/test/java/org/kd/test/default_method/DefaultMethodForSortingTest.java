package org.kd.test.default_method;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DefaultMethodForSortingTest {

    @Test
    public void testNaturalOrderSorting(){
        var integers = Arrays.asList(4,9, 2, 1, 4);

        integers.sort(Comparator.reverseOrder());

        assertThat(integers, is(List.of(9, 4, 4, 2 ,1)));
    }
}
