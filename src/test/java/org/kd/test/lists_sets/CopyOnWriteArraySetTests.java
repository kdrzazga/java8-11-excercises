package org.kd.test.lists_sets;

import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static org.testng.Assert.assertEquals;

public class CopyOnWriteArraySetTests {

    @Test
    public void testNullAcceptation() {
        var set = new CopyOnWriteArraySet(Set.of(DayOfWeek.MONDAY, 100));
        set.add(null);

        assertEquals(3, set.size());
    }
}
