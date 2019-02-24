package org.kd.functional_interface.supplier;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuppliersFactoryTest {

    @Test
    public void testGetStream() {

        var factory = new SuppliersFactory();

        Stream<String> princesFromSupplier = factory
                .createRulersSupplier()
                .get();//As a functional interface supplier defines only get method qithout argument

        Stream<String> princesFromStream = factory
                .createRulersStream();

        assertEquals(princesFromStream.findFirst().orElse("from stream")
                , princesFromSupplier.findFirst().orElse("from supplier"));
    }

    @Test
    public void testGetInteger() {
        //nonsense functionality, only to demonstrate Supplier's get
        assertEquals(1981, new SuppliersFactory().createIntegerSupplier().get());
    }
}
