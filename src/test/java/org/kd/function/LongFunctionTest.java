package org.kd.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LongFunctionTest {

    @Test
    public void testIsPositive(){
        assertTrue(new LongFunctionsFactory().isLongPositive.apply(Long.MAX_VALUE));
        assertFalse(new LongFunctionsFactory().isLongPositive.apply(-Long.MAX_VALUE));
    }
}
