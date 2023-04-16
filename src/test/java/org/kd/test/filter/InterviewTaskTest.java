package org.kd.test.filter;

import org.hamcrest.Matchers;
import org.kd.functional_interface.filter.InterviewTask;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

public class InterviewTaskTest {

    @Test
    public void testIndices() {
        var testArray = new int[]{1, 2, 7, 1, 8, 1, 2, 5, 2};
        var indices = Arrays.stream(new InterviewTask().findIndicesWithSum(testArray, "9"))
                .boxed()
                .collect(Collectors.toList());

        var expected = Arrays.stream(new int[]{1, 3, 4})
                .boxed()
                .collect(Collectors.toList());

        assertTrue(indices.removeAll(expected));
        assertThat(indices, Matchers.hasSize(0));
    }
}
