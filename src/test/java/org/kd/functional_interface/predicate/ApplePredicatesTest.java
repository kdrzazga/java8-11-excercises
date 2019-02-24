package org.kd.functional_interface.predicate;

import org.junit.jupiter.api.Test;
import org.kd.ObjectsFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApplePredicatesTest {

    @Test
    public void testGreenApple() {
        assertEquals(1, new ObjectsFactory().createAppleList().stream().filter(new GreenApplePredicate()).count());
    }

    @Test
    public void testHeavyApple() {
        assertEquals("red", new ObjectsFactory().createAppleList().stream().filter(new HeavyApplePredicate()).findFirst().get().getColor());
    }
}
