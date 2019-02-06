package org.kd.functional_interface;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ChurchNumeralTest {

    @Test
    public void testApply1() {
        assertEquals("s".repeat(32), ChurchNumeral.valueOf(5).apply(s -> s + s, "s"));
    }

    @Test
    public void testApply2() {
        var five = ChurchNumeral.valueOf(5);
        System.out.println(five.apply(Math::sqrt, Double.MAX_VALUE));
        assertEquals((Double) 4.2949672959999995E9, (Double) five.apply(Math::sqrt, Double.MAX_VALUE));
    }

    public static void main(String[] a) {
        var five = ChurchNumeral.valueOf(5);
        System.out.println(five.apply(Math::sqrt, Double.MAX_VALUE));
    }

}
