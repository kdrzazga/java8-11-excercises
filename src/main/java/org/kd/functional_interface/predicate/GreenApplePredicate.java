package org.kd.functional_interface.predicate;

import org.kd.Apple;

import java.util.function.Predicate;

class GreenApplePredicate implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equalsIgnoreCase("green");
    }
}
