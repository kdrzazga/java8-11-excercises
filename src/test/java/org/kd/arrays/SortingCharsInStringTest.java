package org.kd.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingCharsInStringTest {

    @Test
    public void testSorting(){
        assertEquals("  aaaaklmot", new SortingCharsInString().sortChars("ala ma kota"));
    }
}
