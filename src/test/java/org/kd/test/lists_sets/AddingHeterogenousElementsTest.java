package org.kd.test.lists_sets;

import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class AddingHeterogenousElementsTest {

    @Test
    public void testTreeSet() {
        assertThrows(ClassCastException.class, () -> {
            var set = new TreeSet();
            set.add("kot");
            set.add(3);
        });
    }

    @Test
    public void testHashSet() {
        HashSet hs = new HashSet();
        hs.add("kot");
        hs.add(3);

        assertEquals(2, hs.size());
    }

    @Test
    public void testLinkedHashSet() {
        LinkedHashSet lhs = new LinkedHashSet();
        lhs.add("kot");
        lhs.add(3);
        assertEquals(2, lhs.size());
    }
}
