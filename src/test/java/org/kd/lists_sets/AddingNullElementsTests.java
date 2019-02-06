package org.kd.lists_sets;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class AddingNullElementsTests {

    @Test(expected = NullPointerException.class)
    public void testTreeSet() {

        var set = new TreeSet();
        set.add(null);
        set.add(Integer.valueOf(3));

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
