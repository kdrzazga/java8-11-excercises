package org.kd.predicate;

import org.kd.Apple;

import java.util.function.Predicate;

class HeavyApplePredicate implements Predicate<Apple> {

    public boolean test(Apple apple){
        return apple.getWeight() > 150;
    }
}
