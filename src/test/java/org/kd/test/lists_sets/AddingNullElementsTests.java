package org.kd.test.lists_sets;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;


public class AddingNullElementsTests {

    @Test
    public void testTreeSet() {

        var set = new TreeSet();
        assertThrows(NullPointerException.class, () -> {
            set.add(null);
            set.add(3);
        });
    }

    @Test
    public void testHashSet() {
        HashSet hs = new HashSet();
        hs.add(null);
        hs.add(20.0);

        assertEquals(2, hs.size());
    }

    @Test
    public void testLinkedHashSet() {
        LinkedHashSet lhs = new LinkedHashSet();
        lhs.add(null);
        assertEquals(1, lhs.size());
    }
}
