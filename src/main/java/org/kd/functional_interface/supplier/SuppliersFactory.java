package org.kd.functional_interface.supplier;

import org.kd.ObjectsFactory;
import org.kd.Person;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class SuppliersFactory {

    Supplier<Stream<String>> createRulersSupplier() {
        Stream<String> rulersStream = new ObjectsFactory().createPolishRulers().stream().map(Person::getName);
        return () -> rulersStream;
    }

    //for comparision
    Stream<String> createRulersStream() {
        Stream<String> rulersStream = new ObjectsFactory().createPolishRulers().stream().map(Person::getName);
        return rulersStream;
    }

    Supplier<Integer> createIntegerSupplier() {
        //return (x) -> 1981; ERROR, no arguments is required
        return () -> 1981;
    }
}
