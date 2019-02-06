package org.kd;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ObjectsFactory {
    public ObjectsFactory() {
    }

    public List<Person> createPolishRulers() {
        return List.of(
                new Person("Leszko", 750),
                new Person("Popiel", 775),
                new Person("Popiel", 800),
                new Person("Piast Kolodziej", 810),
                new Person("Siemowit", 850),
                new Person("Lestek", 880),
                new Person("Siemomysl", 920),
                new Person("Mieszko", 950)
        );
    }

    public List<Apple> createAppleList() {
        return List.of(
                new Apple("red", 200),
                new Apple("blue mutant", 2000),
                new Apple("green", 120)
        );
    }

    public final List<List<String>> createListOfLists() {
        return Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b", "c"));
    }

    public final List<List<List<String>>> createListOfListOfLists() {
        return List.of(new ObjectsFactory().createListOfLists());
    }

    public Set<String> createRomanEmperors() {
        return Set.of("Octavianus Augustus", "Tiberius", "Caligula", "Claudius", "Nero", "Galba", "Otho" );
    }
}
