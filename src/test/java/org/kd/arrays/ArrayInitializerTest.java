package org.kd.arrays;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayInitializerTest {

    @Test
    public void testInitializeArrayRangeUsingArraysFill(){
        var filled = org.kd.arrays.ArrayInitializer.initializeArrayRangeUsingArraysFill();

        assertEquals(0, filled[3]);
    }

    @Test
    public void testInitializeArrayUsingArraysSetAll(){
        var filled = org.kd.arrays.ArrayInitializer.initializeArrayUsingArraysSetAll();

        assertEquals(0, filled[4]);
        assertEquals(0, filled[3]);
        assertEquals(2, filled[2]);
        assertEquals(1, filled[1]);
    }
}
