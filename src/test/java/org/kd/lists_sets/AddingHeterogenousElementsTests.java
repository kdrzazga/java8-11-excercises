package org.kd.lists_sets;

import org.junit.Assert;
import org.junit.Test;
import org.kd.ObjectsFactory;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class AddingHeterogenousElementsTests {

    @Test(expected = ClassCastException.class)
    public void testTreeSet() {

        var set = new TreeSet();
        set.add("kot");
        set.add(Integer.valueOf(3));

    }

    @Test
    public void testHashSet() {
        HashSet hs = new HashSet();
        hs.add("kot");
        hs.add(Integer.valueOf(3));

        assertEquals(2, hs.size());
    }

    @Test
    public void testLinkedHashSet() {
        LinkedHashSet lhs = new LinkedHashSet();
        lhs.add("kot");
        lhs.add(Integer.valueOf(3));
        assertEquals(2, lhs.size());
    }
}
