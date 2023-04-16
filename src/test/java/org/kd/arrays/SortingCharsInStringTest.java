package org.kd.arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortingCharsInStringTest {

    @Test
    public void testSorting(){
        assertEquals("  aaaaklmot", new SortingCharsInString().sortChars("ala ma kota"));
    }
}
