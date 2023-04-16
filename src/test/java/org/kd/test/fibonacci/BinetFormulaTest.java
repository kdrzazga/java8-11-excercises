package org.kd.test.fibonacci;

import org.kd.fibonacci.BinetFormula;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BinetFormulaTest {

    @Test(groups = {"math"})
    public void testBinetFormula(){
        int[] arguments = {12, 10, 8, 6, 2, 1, 0};
        long[] expected = {144, 55, 21, 8, 1, 1, 0};

        for (int i = 0; i < arguments.length; i++) {
            Assert.assertEquals(expected[i], BinetFormula.berechnenMitBinetFormula(arguments[i]));
        }
    }
}
