package org.kd.lists_sets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddingHeterogenousElementsTests {

    @Test
    public void testTreeSet() {
        Assertions.assertThrows(ClassCastException.class, () -> {
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
