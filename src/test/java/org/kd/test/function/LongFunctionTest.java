package org.kd.test.function;

import org.kd.function.LongFunctionsFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LongFunctionTest {

    @Test
    public void testIsPositive(){
        assertTrue(new LongFunctionsFactory().isLongPositive.apply(Long.MAX_VALUE));
        assertFalse(new LongFunctionsFactory().isLongPositive.apply(-Long.MAX_VALUE));
    }
}
