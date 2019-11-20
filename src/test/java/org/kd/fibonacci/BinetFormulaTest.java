package org.kd.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BinetFormulaTest {

    @Test
    public void testBinetFormula(){
        int[] arguments = {12, 10, 8, 6, 2, 1, 0};
        long[] expected = {144, 55, 21, 8, 1, 1, 0};

        for (int i = 0; i < arguments.length; i++) {
            assertEquals(expected[i], BinetFormula.berechnenMitBinetFormula(arguments[i]));
        }
    }
}
