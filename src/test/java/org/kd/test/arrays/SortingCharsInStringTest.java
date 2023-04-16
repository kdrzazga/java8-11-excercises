package org.kd.test.arrays;

import org.kd.arrays.SortingCharsInString;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortingCharsInStringTest {

    @Test(groups = {"unit", "array"})
    public void testSorting(){
        Assert.assertEquals("  aaaaklmot", new SortingCharsInString().sortChars("ala ma kota"));
    }
}
